package cn.wormholestack.mse.facadeimpl.impl;

import cn.wormholestack.mse.biz.gateway.ProxyService;
import cn.wormholestack.mse.common.annotation.MSEGateway;
import cn.wormholestack.mse.common.model.base.BaseReq;
import cn.wormholestack.mse.common.model.base.BaseRes;
import cn.wormholestack.mse.facadeimpl.GatewayServiceProvider;
import cn.wormholestack.mse.facadeimpl.converter.Converter;
import cn.wormholestack.mse.facadeimpl.validator.Validator;
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
    public void run(String... args) throws Exception {
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
            MSEGateway mseGateway = converter.getClass().getDeclaredAnnotation(MSEGateway.class);
            if (mseGateway == null) {
                throw new IllegalStateException("Cannot register Converter, please make sure place annotation @MSEGateway on converter, converter: " + converter.getClass().getName());
            }
            String serviceName = mseGateway.Service().getCode();
            if (CONVERTERS.get(serviceName) != null) {
                throw new IllegalStateException(
                        "Cannot register ProxyService, please make sure place annotation @MSEGateway on service, service: " + converter.getClass().getName());
            }
            CONVERTERS.put(serviceName, converter);
            logger.info("Registering Converter: 【{}】 - {}", serviceName, converter.getClass().getName());
        }
    }

    /**
     * 注册网关服务校验器
     */
    private void registerValidators() {
        logger.info("Starting Register Validators");
        Map<String, Validator> validators = applicationContext.getBeansOfType(Validator.class, false, true);
        if (validators.isEmpty()) {
            throw new IllegalStateException("Cannot register Converter, please make sure the Converter setup as spring bean");
        }
        for (Validator validator : validators.values()) {
            MSEGateway mseGateway = validator.getClass().getDeclaredAnnotation(MSEGateway.class);
            if (mseGateway == null) {
                throw new IllegalStateException("Cannot register Validator, please make sure place annotation @MSEGateway on Validator, validator: " + validator.getClass().getName());
            }
            String serviceName = mseGateway.Service().getCode();
            if (VALIDATORS.get(serviceName) != null) {
                throw new IllegalStateException(
                        "Cannot register ProxyService, please make sure place annotation @MSEGateway on service, service: " + validator.getClass().getName());
            }
            VALIDATORS.put(serviceName, validator);
            logger.info("Registering Validator: 【{}】 - {}", serviceName, validator.getClass().getName());
        }
    }


    /**
     * 注册网关服务
     */
    private void registerServices() {
        logger.info("Starting Register GatewayServices");
        Map<String, ProxyService> Services = applicationContext.getBeansOfType(ProxyService.class, false, true);
        if (Services.isEmpty()) {
            throw new IllegalStateException("Cannot register ProxyService, please make sure the ProxyService setup as spring bean");
        }
        for (ProxyService service : Services.values()) {
            MSEGateway mseGateway = service.getClass().getDeclaredAnnotation(MSEGateway.class);
            if (mseGateway == null) {
                throw new IllegalStateException(
                        "Cannot register ProxyService, please make sure place annotation @MSEGateway on service, service: " + service.getClass().getName());
            }
            String serviceName = mseGateway.Service().getCode();
            if (this.SERVICES.get(serviceName) != null) {
                throw new IllegalStateException(
                        "Cannot register ProxyService, please make sure place annotation @MSEGateway on service, service: " + service.getClass().getName());
            }
            this.SERVICES.put(serviceName, service);
            logger.info("Registering ProxyServer: 【{}】 - {}", serviceName, service.getClass().getName());
        }
    }
}
