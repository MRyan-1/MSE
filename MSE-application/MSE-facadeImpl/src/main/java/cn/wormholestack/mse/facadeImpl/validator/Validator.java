package cn.wormholestack.mse.facadeImpl.validator;

import cn.wormholestack.mse.common.exception.ValidateException;
import cn.wormholestack.mse.common.model.base.BaseReq;

/**
 * @description： 网关服务校验器
 * @Author MRyan
 * @Date 2021/11/13 21:33
 * @Version 1.0
 */
public interface Validator<Req extends BaseReq> {

    void validate(Req req) throws ValidateException;
}
