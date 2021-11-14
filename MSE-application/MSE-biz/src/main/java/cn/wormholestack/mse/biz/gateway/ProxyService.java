package cn.wormholestack.mse.biz.gateway;

import cn.wormholestack.mse.common.exception.ServiceException;
import cn.wormholestack.mse.common.model.base.ResponseContext;

/**
 * @description： 网关服务代理
 * @Author MRyan
 * @Date 2021/11/13 16:11
 * @Version 1.0
 */
public interface ProxyService<Req, Res> {

    ResponseContext<Res> invoke(Req inVO) throws ServiceException;
}
