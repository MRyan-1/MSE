package cn.wormholestack.mse.facadeImpl;

import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import cn.wormholestack.mse.common.model.base.BaseReq;
import cn.wormholestack.mse.common.model.base.BaseRes;

/**
 * @description： 网关入口
 * @Author MRyan
 * @Date 2021/11/13 15:50
 * @Version 1.0
 */
public interface GatewayServiceEntrance<Req extends BaseReq, Res extends BaseRes, InVO, OutVO> {

    /**
     * 网关入口，根据服务网关方法，调度具体的业务接口执行业务逻辑
     *
     * @param gatewayMethod
     * @param request
     * @param response
     * @return
     */
    Res invoke(GatewayServiceEnum gatewayMethod, Req request, Res response);
}
