package cn.wormholestack.mse.common.model.base;

import java.io.Serializable;

/**
 * @description： Request基类
 * @Author MRyan
 * @Date 2021/11/13 14:01
 * @Version 1.0
 */
public class BaseReq implements Serializable {

    /**
     * 请求ip
     */
    private String ip;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 请求token
     */
    private String token;

    /**
     * 请求会话ID
     */
    private String sessionId;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
