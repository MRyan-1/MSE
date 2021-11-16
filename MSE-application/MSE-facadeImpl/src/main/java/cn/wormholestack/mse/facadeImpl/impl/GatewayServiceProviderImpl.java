package cn.wormholestack.mse.facadeImpl.impl;

import cn.wormholestack.mse.business.gateway.ProxyService;
import cn.wormholestack.mse.common.annotation.MSEGateway;
import cn.wormholestack.mse.common.model.base.BaseReq;
import cn.wormholestack.mse.common.model.base.BaseRes;
import cn.wormholestack.mse.common.utils.AopTargetUtils;
import cn.wormholestack.mse.facadeImpl.GatewayServiceProvider;
import cn.wormholestack.mse.facadeImpl.Interceptor.Interceptor;
import cn.wormholestack.mse.facadeImpl.converter.Converter;
import cn.wormholestack.mse.facadeImpl.validator.Validator;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description： 网关服务提供者实现
 * @Author MRyan
 * @Date 2021/11/13 20:10
 * @Version 1.0
 */
@Service
public class GatewayServiceProviderImpl<Req extends BaseReq, Res extends BaseRes, InVO, OutVO>
        implements GatewayServiceProvider<Req, Res, InVO, OutVO>, CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(GatewayServiceProviderImpl.class);

    /**
     * spring上下文
     */
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 网关服务集
     */
    private final Map<String, ProxyService<InVO, OutVO>> SERVICES = Maps.newConcurrentMap();

    /**
     * 网关服务数据转换器
     */
    private final Map<String, Converter<Req, Res, InVO, OutVO>> CONVERTERS = Maps.newConcurrentMap();

    /**
     * 网关服务校验器
     */
    private final Map<String, Validator<Req>> VALIDATORS = Maps.newConcurrentMap();

    /**
     * 拦截器
     */
    private final Map<String, Interceptor> INTERCEPTOR = Maps.newConcurrentMap();

    @Override
    public ProxyService<InVO, OutVO> getProxyService(String ServiceName) {
        return SERVICES.get(ServiceName);
    }

    @Override
    public Converter<Req, Res, InVO, OutVO> getConverter(String serviceName) {
        return CONVERTERS.get(serviceName);
    }

    @Override
    public Validator<Req> getValidator(String serviceName) {
        return VALIDATORS.get(serviceName);
    }

    @Override
    public Interceptor getInterceptor(String serviceName) {
        return INTERCEPTOR.get(serviceName);
    }


    @Override
    public void run(String... args) throws Exception {
        //注册拦截器
        registerInterceptor();
        //注册网关服务校验器
        registerValidators();
        //注册网关服务数据转换器
        registerConverters();
        //注册网关服务
        registerServices();
    }

    /**
     * 注册网关服务数据转换器
     */
    private void registerConverters() {
        logger.info("Starting Register Converters");
        Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class, false, true);
        if (converters.isEmpty()) {
            throw new IllegalStateException("Cannot register Converter, please make sure the Converter setup as spring bean");
        }
        for (Converter converter : converters.values()) {
            Converter converterProxy = (Converter) AopTargetUtils.getTarget(converter);
            MSEGateway mseGateway = converter.getClass().getDeclaredAnnotation(MSEGateway.class);
            if (mseGateway == null) {
                throw new IllegalStateException("Cannot register Converter, please make sure place annotation @MSEGateway on Converter, converter: " + converterProxy.getClass().getName());
            }
            String converterName = mseGateway.service().getService();
            if (CONVERTERS.get(converterName) != null) {
                throw new IllegalStateException(
                        "Cannot register ProxyService, please make sure place annotation @MSEGateway on Converter, converter: " + converterProxy.getClass().getName());
            }
            CONVERTERS.put(converterName, converterProxy);
            logger.info("Registering Converter: 【{}】 - {}", converterName, converterProxy.getClass().getName());
        }
    }

    /**
     * 注册网关服务校验器
     */
    private void registerValidators() {
        logger.info("Starting Register Validators");
        Map<String, Validator> validators = applicationContext.getBeansOfType(Validator.class, false, true);
        if (validators.isEmpty()) {
            throw new IllegalStateException("Cannot register Converter, please make sure the Validator setup as spring bean");
        }
        for (Validator validator : validators.values()) {
            Validator validatorProxy = (Validator) AopTargetUtils.getTarget(validator);
            MSEGateway mseGateway = validator.getClass().getDeclaredAnnotation(MSEGateway.class);
            if (mseGateway == null) {
                throw new IllegalStateException("Cannot register Validator, please make sure place annotation @MSEGateway on Validator, validator: " + validatorProxy.getClass().getName());
            }
            String validatorName = mseGateway.service().getService();
            if (VALIDATORS.get(validatorName) != null) {
                throw new IllegalStateException(
                        "Cannot register ProxyService, please make sure place annotation @MSEGateway on Validator, validator: " + validatorProxy.getClass().getName());
            }
            VALIDATORS.put(validatorName, validatorProxy);
            logger.info("Registering Validator: 【{}】 - {}", validatorName, validatorProxy.getClass().getName());
        }
    }


    /**
     * 注册网关服务
     */
    private void registerServices() {
        logger.info("Starting Register GatewayServices");
        Map<String, ProxyService> services = applicationContext.getBeansOfType(ProxyService.class, false, true);
        if (services.isEmpty()) {
            throw new IllegalStateException("Cannot register ProxyService, please make sure the ProxyService setup as spring bean");
        }
        for (ProxyService service : services.values()) {
            ProxyService serviceProxy = (ProxyService) AopTargetUtils.getTarget(service);
            MSEGateway mseGateway = serviceProxy.getClass().getDeclaredAnnotation(MSEGateway.class);
            if (mseGateway == null) {
                throw new IllegalStateException(
                        "Cannot register ProxyService, please make sure place annotation @MSEGateway on ProxyService, service: " + serviceProxy.getClass().getName());
            }
            String serviceName = mseGateway.service().getService();
            if (this.SERVICES.get(serviceName) != null) {
                throw new IllegalStateException(
                        "Cannot register ProxyService, please make sure place annotation @MSEGateway on ProxyService, service: " + serviceProxy.getClass().getName());
            }
            this.SERVICES.put(serviceName, serviceProxy);
            logger.info("Registering ProxyServer: 【{}】 - {}", serviceName, serviceProxy.getClass().getName());
        }
    }

    /**
     * 注册拦截器
     */
    private void registerInterceptor() {
        logger.info("Starting Register Interceptor");
        Map<String, Interceptor> interceptors = applicationContext.getBeansOfType(Interceptor.class, false, true);
        if (interceptors.isEmpty()) {
            throw new IllegalStateException("Cannot register Interceptor, please make sure the Interceptor setup as spring bean");
        }
        for (Interceptor interceptor : interceptors.values()) {
            Interceptor interceptorProxy = (Interceptor) AopTargetUtils.getTarget(interceptor);
            MSEGateway mseGateway = interceptorProxy.getClass().getDeclaredAnnotation(MSEGateway.class);
            if (mseGateway == null) {
                throw new IllegalStateException(
                        "Cannot register Interceptor, please make sure place annotation @MSEGateway on Interceptor, interceptor: " + interceptorProxy.getClass().getName());
            }
            String interceptorName = mseGateway.service().getService();
            if (this.SERVICES.get(interceptorName) != null) {
                throw new IllegalStateException(
                        "Cannot register Interceptor, please make sure place annotation @MSEGateway on Interceptor, interceptor: " + interceptorProxy.getClass().getName());
            }
            this.INTERCEPTOR.put(interceptorName, interceptorProxy);
            logger.info("Registering Interceptor: 【{}】 - {}", interceptorName, interceptorProxy.getClass().getName());
        }
    }
}
