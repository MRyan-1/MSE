package cn.wormholestack.mse.common.model.base;

import java.io.Serializable;

/**
 * @description： BaseVO
 * @Author MRyan
 * @Date 2021/11/13 17:03
 * @Version 1.0
 */
public class BaseVO implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
