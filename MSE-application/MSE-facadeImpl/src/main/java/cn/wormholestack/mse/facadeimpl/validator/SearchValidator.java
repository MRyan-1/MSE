package cn.wormholestack.mse.facadeimpl.validator;

import cn.wormholestack.mse.common.annotation.MSEGateway;
import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import cn.wormholestack.mse.facade.model.search.SearchReq;
import org.springframework.stereotype.Service;

/**
 * @description： 搜索服务校验器实现
 * @Author MRyan
 * @Date 2021/11/13 22:13
 * @Version 1.0
 */
@Service
@MSEGateway(Service = GatewayServiceEnum.SEARCH)
public class SearchValidator implements Validator<SearchReq> {

    @Override
    public void validate(SearchReq req) {

    }
}
