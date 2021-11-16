package cn.wormholestack.mse.business.service.search;

import cn.wormholestack.mse.business.gateway.ProxyService;
import cn.wormholestack.mse.common.annotation.MSEGateway;
import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import cn.wormholestack.mse.common.exception.ServiceException;
import cn.wormholestack.mse.common.model.base.ResponseContext;
import cn.wormholestack.mse.common.model.search.QueryResVO;
import cn.wormholestack.mse.common.model.search.SearchReqVO;
import cn.wormholestack.mse.common.model.search.SearchResVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description： 搜索服务实现
 * @Author MRyan
 * @Date 2021/11/13 16:50
 * @Version 1.0
 */
@Service
@MSEGateway(service = GatewayServiceEnum.SEARCH)
public class SearchServiceImpl implements ProxyService<SearchReqVO, SearchResVO> {

    private Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Override
    public ResponseContext<SearchResVO> invoke(SearchReqVO inVO) throws ServiceException {
        //test
        logger.info("搜索服务");
        ResponseContext<SearchResVO> context = new ResponseContext<>();
        SearchResVO searchResVO = new SearchResVO();
        searchResVO.setCount(1L);
        List<QueryResVO> queryResVOS = new ArrayList<>();
        QueryResVO queryResVO = new QueryResVO();
        queryResVO.setDocId(1);
        queryResVO.setDocTitle("this is a test case!");
        queryResVO.setDocUrl("www.test.com");
        queryResVOS.add(queryResVO);
        searchResVO.setData(queryResVOS);
        context.setResponse(searchResVO);
        context.setSuccess(true);
        return context;
    }
}
