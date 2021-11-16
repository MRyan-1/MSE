package cn.wormholestack.mse.common.annotation;

import cn.wormholestack.mse.common.enums.CLStrategyEnum;
import cn.wormholestack.mse.common.enums.GatewayServiceEnum;

import java.lang.annotation.*;

/**
 * @description： 限流
 * @Author MRyan
 * @Date 2021/11/17 00:12
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface CL {

    /**
     * 限流策略
     *
     * @return
     */
    CLStrategyEnum strategy() default CLStrategyEnum.SENTINEL;

    /**
     * 限流服务
     *
     * @return
     */
    GatewayServiceEnum service();
}
