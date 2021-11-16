package cn.wormholestack.mse.facadeImpl.converter;

import cn.wormholestack.mse.common.annotation.MSEGateway;
import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import cn.wormholestack.mse.common.exception.ConverterException;
import cn.wormholestack.mse.common.model.base.ResponseContext;
import cn.wormholestack.mse.common.model.search.SearchReqVO;
import cn.wormholestack.mse.common.model.search.SearchResVO;
import cn.wormholestack.mse.facade.model.search.SearchReq;
import cn.wormholestack.mse.facade.model.search.SearchRes;
import cn.wormholestack.mse.facadeImpl.mapper.SearchMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description： 搜索服务数据转换器实现
 * @Author MRyan
 * @Date 2021/11/13 22:13
 * @Version 1.0
 */
@Service
@MSEGateway(service = GatewayServiceEnum.SEARCH)
public class SearchConverter implements Converter<SearchReq, SearchRes, SearchReqVO, SearchResVO> {

    @Resource
    private SearchMapper searchMapper;

    @Override
    public SearchReqVO requestToVO(SearchReq req) throws ConverterException {
        return searchMapper.dto2vo(req);
    }

    @Override
    public SearchRes voToResponse(ResponseContext<SearchResVO> vo) throws ConverterException {
        SearchRes searchRes = new SearchRes();
        searchRes.setSuccess(vo.isSuccess());
        searchRes.setCode(vo.getCode());
        searchRes.setMessage(vo.getMessage());
        searchRes.setData(searchMapper.vo2dtos(vo.getResponse().getData()));
        searchRes.setCount(vo.getResponse().getCount());
        return searchRes;
    }
}
