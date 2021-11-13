package cn.wormholestack.mse.facadeimpl.converter;

import cn.wormholestack.mse.common.model.base.BaseReq;
import cn.wormholestack.mse.common.model.base.BaseRes;
import cn.wormholestack.mse.common.model.base.ResponseContext;

/**
 * @description： 网关服务数据转换器
 * @Author MRyan
 * @Date 2021/11/13 21:37
 * @Version 1.0
 */
public interface Converter<ReqDTO extends BaseReq, ResDTO extends BaseRes, ReqVO, ResVO> {

    /**
     * 网关请求参数转换为业务层需要的入参模型
     *
     * @param request 网关请求参数
     * @return 业务层入参模型
     */
    ReqVO requestToVO(ReqDTO request);

    /**
     * 业务层返回的数据模型转换层网关需要的应答参数
     *
     * @param vo 业务层返回的数据模型
     * @return 网关应答参数
     */
    ResDTO voToResponse(ResponseContext<ResVO> vo);


}

