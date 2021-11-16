package cn.wormholestack.mse.facade.model.search;


import cn.wormholestack.mse.common.model.base.BasePage;
import lombok.*;

/**
 * @description： 搜索入参 分页
 * @Author MRyan
 * @Date 2021/11/13 14:35
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchReq extends BasePage {

    /**
     * 搜索内容
     */
    private String question;

    /**
     * 类型
     */
    private String type;

}
