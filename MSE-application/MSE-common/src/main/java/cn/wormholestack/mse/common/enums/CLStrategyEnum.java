package cn.wormholestack.mse.common.enums;

/**
 * @description： 限流策略
 * @Author MRyan
 * @Date 2021/11/16 22:13
 * @Version 1.0
 */
public enum CLStrategyEnum {

    SENTINEL("SENTINEL");

    private final String strategy;

    CLStrategyEnum(String strategy) {
        this.strategy = strategy;
    }

    public String getStrategy() {
        return strategy;
    }
}
