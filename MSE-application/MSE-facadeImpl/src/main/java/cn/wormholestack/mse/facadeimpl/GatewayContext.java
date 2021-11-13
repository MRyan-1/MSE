package cn.wormholestack.mse.facadeimpl;

import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import cn.wormholestack.mse.common.model.base.ResponseContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.util.StopWatch;

import java.io.Serializable;
import java.util.Date;

/**
 * @description： 网关上下文
 * @Author MRyan
 * @Date 2021/11/13 16:28
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayContext<Req, Res> implements Serializable {

    /**
     * 请求参数
     */
    private Req request;
    /**
     * 调用返回参数
     */
    private ResponseContext<Res> response;

    /**
     * 调用的方法
     */
    private GatewayServiceEnum method;

    /**
     * 上下文创建时间
     */
    private Date startTime = new Date();

    /**
     * 计时器
     */
    private StopWatch stopWatch = new StopWatch();


    /**
     * 构造方法
     *
     * @param method
     */
    public GatewayContext(GatewayServiceEnum method) {
        this.method = method;
    }
}
