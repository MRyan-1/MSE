package cn.wormholestack.mse.facadeimpl.impl;

import cn.wormholestack.mse.biz.gateway.ProxyService;
import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import cn.wormholestack.mse.common.model.base.BaseReq;
import cn.wormholestack.mse.common.model.base.BaseRes;
import cn.wormholestack.mse.common.model.base.ResponseContext;
import cn.wormholestack.mse.facadeimpl.GatewayContext;
import cn.wormholestack.mse.facadeimpl.GatewayServiceEntrance;
import cn.wormholestack.mse.facadeimpl.GatewayServiceProvider;
import cn.wormholestack.mse.facadeimpl.converter.Converter;
import cn.wormholestack.mse.facadeimpl.validator.Validator;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * @description： 网关入口默认实现
 * @Author MRyan
 * @Date 2021/11/13 15:54
 * @Version 1.0
 */
@Service
public class DefaultGatewayServiceEntrance<Req extends BaseReq, Res extends BaseRes, InVO, OutVO>
        implements GatewayServiceEntrance<Req, Res, InVO, OutVO> {

    private static Logger logger = LoggerFactory.getLogger(DefaultGatewayServiceEntrance.class);

    /**
     * 服务网关提供商
     */
    @Resource
    private GatewayServiceProvider<Req, Res, InVO, OutVO> provider;


    @Override
    public Res invoke(GatewayServiceEnum gatewayMethod, Req req, Res res) {
        GatewayContext<InVO, OutVO> context = new GatewayContext<>(gatewayMethod);
        context.getStopWatch().start();
        Res result;
        logger.info("MSEGateway调用入参={}", JSON.toJSON(req));
        try {
            //0.流控
            //1.请求参数校验
            doValidation(req, context);
            //2.数据转换
            doPreConverter(req, context);
            //3.执行前置处理器
            //4.调用服务
            doCallService(context);
            //5.数据转换
            result = doPostConverter(context);
            //6.执行后置处理器
            return result;
        } catch (Exception e) {
            logger.error("系统异常!", e);
            result = getResFromException(context, res, "系统异常!", new Exception(e));
            return result;
        } finally {
            if (context.getStopWatch().isRunning()) {
                context.getStopWatch().stop();
            }
        }
    }

    /**
     * 前置出参转换
     *
     * @param context
     * @return
     */
    private Res doPostConverter(GatewayContext<InVO, OutVO> context) {
        String serviceName = context.getMethod().getCode();
        Converter<Req, Res, InVO, OutVO> converter = provider.getConverter(serviceName);
        if (converter == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found Converter for service: " + serviceName);
        }
        startStopWatch(context.getStopWatch(), "postConverter");
        Res res = converter.voToResponse(context.getResponse());
        context.getStopWatch().stop();
        return res;
    }

    /**
     * 前置入参转换
     *
     * @param req
     * @param context
     * @return
     */
    private InVO doPreConverter(Req req, GatewayContext<InVO, OutVO> context) {
        String serviceName = context.getMethod().getCode();
        Converter<Req, Res, InVO, OutVO> converter = provider.getConverter(serviceName);
        if (converter == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found Converter for service: " + serviceName);
        }
        startStopWatch(context.getStopWatch(), "preConverter");
        InVO inVO = converter.requestToVO(req);
        context.setRequest(inVO);
        context.getStopWatch().stop();
        return inVO;
    }

    private void doValidation(Req req, GatewayContext<InVO, OutVO> context) {
        String serviceName = context.getMethod().getCode();
        Validator<Req> validator = provider.getValidator(serviceName);
        if (validator == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found Validator for service: " + serviceName);
        }
        startStopWatch(context.getStopWatch(), "validate");
        validator.validate(req);
        context.getStopWatch().stop();
    }

    private Res getResFromException(GatewayContext<InVO, OutVO> context, Res res, String msg, Exception e) {
        logger.warn(msg + " msg={}", e.getMessage(), e);
        res.setSuccess(false);
        res.setMessage(msg);
        return res;
    }

    /**
     * 调用服务
     *
     * @param context
     * @return
     */
    private GatewayContext<InVO, OutVO> doCallService(GatewayContext<InVO, OutVO> context) {
        ProxyService<InVO, OutVO> service = provider.getProxyService(context.getMethod().getCode());
        if (service == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found  service: " + context.getMethod().getCode());
        }
        startStopWatch(context.getStopWatch(), "service");
        ResponseContext<OutVO> responseContext = service.invoke(context.getRequest());
        context.setResponse(responseContext);
        context.getStopWatch().stop();
        return context;
    }

    /**
     * 启动计时器
     *
     * @param stopWatch
     * @param name
     */
    private void startStopWatch(StopWatch stopWatch, String name) {
        if (stopWatch.isRunning()) {
            stopWatch.stop();
        }
        stopWatch.start(name);
    }
}
