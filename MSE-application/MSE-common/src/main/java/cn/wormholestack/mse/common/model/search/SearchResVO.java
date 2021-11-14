package cn.wormholestack.mse.common.model.search;

import cn.wormholestack.mse.common.model.base.BaseVO;
import lombok.*;

import java.util.List;

/**
 * @description： SearchResVO
 * @Author MRyan
 * @Date 2021/11/13 17:09
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchResVO extends BaseVO {

    /**
     * 数据总数
     */
    private Long count;

    /**
     * 数据集合
     */
    private List<QueryResVO> data;

}
