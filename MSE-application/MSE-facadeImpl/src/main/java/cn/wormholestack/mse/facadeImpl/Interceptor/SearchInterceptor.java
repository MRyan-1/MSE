package cn.wormholestack.mse.facadeImpl.Interceptor;

import cn.wormholestack.mse.common.annotation.MSEGateway;
import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import cn.wormholestack.mse.common.exception.InterceptException;
import cn.wormholestack.mse.facadeImpl.GatewayContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description： 查询拦截器
 * @Author MRyan
 * @Date 2021/11/16 21:13
 * @Version 1.0
 */
@Service
@MSEGateway(service = GatewayServiceEnum.SEARCH)
public class SearchInterceptor extends AbstractBaseInterceptor {

    private Logger logger = LoggerFactory.getLogger(SearchInterceptor.class);

    @Override
    protected <InVO, OutVO> InVO invoke(GatewayContext<InVO, OutVO> context) throws InterceptException {
        logger.info("SearchInterceptor:{}", context.getRequest());
        return context.getRequest();
    }
}
