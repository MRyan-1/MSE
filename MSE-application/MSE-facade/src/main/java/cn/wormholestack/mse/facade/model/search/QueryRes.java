package cn.wormholestack.mse.facade.model.search;

import lombok.*;

/**
 * @description： 网页搜索的结果返回
 * @Author MRyan
 * @Date 2021/11/13 15:17
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class QueryRes {

    /**
     * 网页的id
     */
    private long docId;

    /**
     * 网页的链接
     */
    private String docUrl;

    /**
     * 统计出现的次数
     */
    private int countNum;

    /**
     * 标题预留，用做网页的摘要
     */
    private String docTitle;

}
