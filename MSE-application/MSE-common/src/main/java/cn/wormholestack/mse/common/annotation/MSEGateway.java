package cn.wormholestack.mse.common.annotation;

import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.*;

/**
 * @description： 网关注解
 * @Author MRyan
 * @Date 2021/11/13 14:12
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface MSEGateway {

    String name() default StringUtils.EMPTY;

    GatewayServiceEnum Service();

}
