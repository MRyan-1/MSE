package cn.wormholestack.mse.common.model.search;

import cn.wormholestack.mse.common.enums.search.SearchTypeEnum;
import cn.wormholestack.mse.common.model.base.BaseVO;
import lombok.*;

/**
 * @description： SearchVO
 * @Author MRyan
 * @Date 2021/11/13 17:03
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchReqVO extends BaseVO {

    /**
     * 搜索内容
     */
    private String question;

    /**
     * 类型
     */
    private SearchTypeEnum type;

}
