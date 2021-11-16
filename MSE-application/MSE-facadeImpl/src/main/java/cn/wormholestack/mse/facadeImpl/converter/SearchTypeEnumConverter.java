package cn.wormholestack.mse.facadeImpl.converter;

import cn.wormholestack.mse.common.enums.SearchTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @description： SearchTypeEnumConverter
 * @Author MRyan
 * @Date 2021/11/13 22:33
 * @Version 1.0
 */
@Component
public class SearchTypeEnumConverter {

    public String asString(SearchTypeEnum refundType) {
        if (refundType != null) {
            return refundType.getType();
        }
        return null;
    }

    public SearchTypeEnum asCertTypeEnum(String refundSource) {
        if (StringUtils.isBlank(refundSource)) {
            return null;
        }
        return SearchTypeEnum.getEnumByCode(refundSource);
    }
}
