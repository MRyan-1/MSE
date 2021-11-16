package cn.wormholestack.mse.facadeImpl.Interceptor;

import cn.wormholestack.mse.common.exception.InterceptException;
import cn.wormholestack.mse.facadeImpl.GatewayContext;

/**
 * @description： 拦截器
 * @Author MRyan
 * @Date 2021/11/16 20:59
 * @Version 1.0
 */
public interface Interceptor {

    /**
     * 拦截
     */
    <InVO, OutVO> InVO intercept(GatewayContext<InVO, OutVO> context) throws InterceptException;
}
