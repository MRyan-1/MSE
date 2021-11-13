package cn.wormholestack.mse.common.enums.search;

import org.apache.commons.lang3.StringUtils;

/**
 * @description： 搜索类型枚举
 * @Author MRyan
 * @Date 2021/11/13 14:42
 * @Version 1.0
 */
public enum SearchTypeEnum {

    WEB("web"),
    VIDEO("video"),
    BOOK("book"),
    NEW("new"),
    IMAGE("image");

    /**
     * 搜索类型
     */
    private String type;

    SearchTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * 获取枚举类型
     *
     * @param code 枚举码
     * @return
     */
    public static SearchTypeEnum getEnumByCode(String type) {
        if (StringUtils.isEmpty(type)) {
            return null;
        }
        for (SearchTypeEnum e : SearchTypeEnum.values()) {
            if (type.equals(e.getType())) {
                return e;
            }
        }
        return null;
    }

}
