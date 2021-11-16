package cn.wormholestack.mse.facade.model.search;

import cn.wormholestack.mse.common.model.base.BaseRes;
import lombok.*;

import java.util.List;

/**
 * @description： 搜索出参
 * @Author MRyan
 * @Date 2021/11/13 15:14
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SearchRes extends BaseRes {

    /**
     * 数据总数
     */
    private Long count;

    /**
     * 数据集合
     */
    private List<QueryRes> data;

}
