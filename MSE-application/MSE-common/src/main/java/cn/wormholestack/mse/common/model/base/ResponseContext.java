package cn.wormholestack.mse.common.model.base;

import java.io.Serializable;
import java.util.Map;

/**
 * @description： ResponseContext
 * @Author MRyan
 * @Date 2021/11/13 16:12
 * @Version 1.0
 */
public class ResponseContext<T> implements Serializable {

    /**
     * 返回主体内容
     */
    private T response;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 消息代码
     */
    private String code;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 需要传递的其他信息.
     */
    private Object obj;

    /**
     * 扩展字段，传递额外信息
     */
    private Map<String, Object> extInfo;

    /**
     * 空参构造函数
     */
    public ResponseContext() {
    }

    /**
     * 带参数构造函数
     *
     * @param success
     * @param code
     * @param message
     */
    public ResponseContext(boolean success, String code, String message) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 带参数构造函数
     *
     * @param response
     * @param success
     * @param code
     * @param message
     */
    public ResponseContext(T response, boolean success, String code, String message) {
        super();
        this.response = response;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ResponseContext(T response) {
        this.success = true;
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public ResponseContext<T> setResponse(T response) {
        this.response = response;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public ResponseContext<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ResponseContext<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseContext<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Map<String, Object> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(Map<String, Object> extInfo) {
        this.extInfo = extInfo;
    }
}
