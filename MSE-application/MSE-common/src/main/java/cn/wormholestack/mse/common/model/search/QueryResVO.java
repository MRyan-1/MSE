package cn.wormholestack.mse.common.model.search;

import cn.wormholestack.mse.common.model.base.BaseVO;
import lombok.*;

/**
 * @description： QueryResVO
 * @Author MRyan
 * @Date 2021/11/13 17:11
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryResVO extends BaseVO {

    /**
     * 网页的id
     */
    private long docId;

    /**
     * 网页的内容
     */
    private String docUrl;

    /**
     * 统计出现的次数
     */
    private int countNum;

    /**
     * 预留，用做网页的摘要
     */
    private String docTitle;

    /**
     * 预留，图片url
     */
    private String imgUrl;

}
