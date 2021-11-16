package cn.wormholestack.mse.common.model.base;

import java.io.Serializable;

/**
 * @description： Response基类
 * @Author MRyan
 * @Date 2021/11/13 14:06
 * @Version 1.0
 */
public class BaseRes implements Serializable {

    /**
     * 是否成功 默认成功
     */
    private boolean success = true;

    /**
     * Code
     */
    private String code;

    /**
     * 内容
     */
    private String message;

    public BaseRes() {
    }

    public BaseRes(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
