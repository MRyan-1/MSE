package cn.wormholestack.mse.common.enums;

/**
 * @description： 网关方法枚举
 * @Author MRyan
 * @Date 2021/11/13 14:16
 * @Version 1.0
 */
public enum GatewayServiceEnum {

    /*-------------------外部接口-------------------------*/
    /**
     * 搜索核心
     */
    SEARCH("search");


    /*-------------------内部接口-------------------------*/

    /**
     * 枚举编码
     */
    private final String code;

    /**
     * 私有构造函数
     */
    GatewayServiceEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
