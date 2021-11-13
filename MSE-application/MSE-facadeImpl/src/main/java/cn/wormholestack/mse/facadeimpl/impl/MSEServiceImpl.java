package cn.wormholestack.mse.facadeimpl.impl;

import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import cn.wormholestack.mse.facade.MSEService;
import cn.wormholestack.mse.facade.model.search.SearchReq;
import cn.wormholestack.mse.facade.model.search.SearchRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description： MSE服务实现
 * @Author MRyan
 * @Date 2021/11/13 15:22
 * @Version 1.0
 */
@Service("mseService")
public class MSEServiceImpl implements MSEService {

    private static final Logger logger = LoggerFactory.getLogger(MSEServiceImpl.class);

    @Resource
    private DefaultGatewayServiceEntrance defaultGatewayServiceEntrance;

    /**
     * 搜索服务
     *
     * @param req
     * @return
     */
    @Override
    public SearchRes search(SearchReq req) {
        return (SearchRes) defaultGatewayServiceEntrance.invoke(GatewayServiceEnum.SEARCH, req, new SearchRes());
    }

}
