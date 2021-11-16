package cn.wormholestack.mse.facadeImpl.Interceptor;

import cn.wormholestack.mse.common.exception.InterceptException;
import cn.wormholestack.mse.facadeImpl.GatewayContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description： 拦截器基类
 * @Author MRyan
 * @Date 2021/11/16 21:15
 * @Version 1.0
 */
public abstract class AbstractBaseInterceptor implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(AbstractBaseInterceptor.class);

    /**
     * 拦截，相当于前置处理过滤
     *
     * @param context
     * @param <InVO>
     * @param <OutVO>
     * @return
     * @throws InterceptException
     */
    @Override
    public <InVO, OutVO> InVO intercept(GatewayContext<InVO, OutVO> context) throws InterceptException {
        logger.info("Trigger interception mechanism!  method -> {}", context.getMethod());
        return invoke(context);
    }

    protected abstract <InVO, OutVO> InVO invoke(GatewayContext<InVO, OutVO> context) throws InterceptException;
}
