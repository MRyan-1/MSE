package cn.wormholestack.mse.business.aspect;

import cn.wormholestack.mse.common.annotation.CL;
import cn.wormholestack.mse.common.enums.CLStrategyEnum;
import cn.wormholestack.mse.common.enums.GatewayServiceEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description： 限流切面
 * @Author MRyan
 * @Date 2021/11/17 00:14
 * @Version 1.0
 */
@Component
@Aspect
public class CLAspect {

    private Logger logger = LoggerFactory.getLogger(CLAspect.class);

    /**
     * 切入点
     */
    @Pointcut("@annotation(cn.wormholestack.mse.common.annotation.CL) && within(cn.wormholestack.mse.facadeImpl.impl..*)")
    public void cl() {
    }

    @Around(value = "cl()")
    public Object searchAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            // 获取本次调用的方法
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            Object target = pjp.getTarget();
            Method method = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
            Object route = null;
            if (method.isAnnotationPresent(CL.class)) {
                CL cl = method.getAnnotation(CL.class);
                GatewayServiceEnum serviceEnum = cl.service();
                CLStrategyEnum strategyEnum = cl.strategy();
                String service = serviceEnum.getService();
                String strategy = strategyEnum.getStrategy();
                logger.info("CLAspect: service->{} strategy->{}", service, strategy);
                //限流

                route = pjp.proceed();

                //放行

            }
            return route;
        } catch (Exception e) {
            throw e;
        }
    }

}
