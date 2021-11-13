package cn.wormholestack.mse.facadeimpl.mapper;

import cn.wormholestack.mse.common.model.search.QueryResVO;
import cn.wormholestack.mse.common.model.search.SearchReqVO;
import cn.wormholestack.mse.common.model.search.SearchResVO;
import cn.wormholestack.mse.facade.model.search.QueryRes;
import cn.wormholestack.mse.facade.model.search.SearchReq;
import cn.wormholestack.mse.facade.model.search.SearchRes;
import cn.wormholestack.mse.facadeimpl.converter.SearchTypeEnumConverter;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;


import java.util.List;

/**
 * @description： 搜索服务数据转换
 * @Author MRyan
 * @Date 2021/11/13 22:23
 * @Version 1.0
 */
@Mapper(componentModel = "spring",
        uses = {
                SearchTypeEnumConverter.class
        },
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface SearchMapper {

    SearchReqVO dto2vo(SearchReq req);

    QueryRes vo2dto(QueryResVO dto);

    List<QueryRes> vo2dtos(List<QueryResVO> dto);


    SearchRes vo2dto(SearchResVO dto);

}
