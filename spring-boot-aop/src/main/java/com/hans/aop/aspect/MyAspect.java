package com.hans.aop.aspect;

import com.hans.aop.validator.UserValidator;
import com.hans.aop.validator.impl.UserValidatorImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 1.记得将切入类交给spring 管理
 * 2.around 、before 、after 同时存在时，日志输出顺序
 * 2021-12-02 22:21:55.217  INFO 11440 --- [nio-8080-exec-1] com.hans.aop.aspect.MyAspect             : aroundAspect before......
 * 2021-12-02 22:21:55.217  INFO 11440 --- [nio-8080-exec-1] com.hans.aop.aspect.MyAspect             : beforeAspect....
 * 2021-12-02 22:21:55.223  INFO 11440 --- [nio-8080-exec-1] com.hans.aop.aspect.MyAspect             : afterAspect....
 * 2021-12-02 22:21:55.223  INFO 11440 --- [nio-8080-exec-1] com.hans.aop.aspect.MyAspect             : aroundAspect end......
 * 3.多个切面同时增强一个方法时，顺序是杂乱的
 *  可以通过 @Order 注解定义顺序、或者实现 Ordered 接口重写 getOrder 接口
 *
 * @Author: hans
 * @Date: 2021/12/2 21:51
 */

@Aspect
@Slf4j
@Component
@Order(1)
public class MyAspect {

    /**
     * @DeclareParents 引入新的类来增强服务，必须配置属性 value 、defaultImpl
     * value 指向要增强的目标对象
     * defaultImpl 引入增强功能的类
     */
    @DeclareParents(value = "com.hans.aop.service.impl.UserImpl",defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.hans.aop.service..*(..))")
    public void cut(){

    }

    /**
     * 无参 @Before("cut()")
     * 获取传参：传递参数给通知
     * 只需在切入点加入正则，也可以使用 JoinPoint 获取参数
     */
    @Before("cut() && args(id)")
    public void beforeAspect(JoinPoint joinPoint, Long id){
        Object[] args = joinPoint.getArgs();
        log.info("beforeAspect....");
        log.info("args ：{}", args);
    }

    @After("cut()")
    public void afterAspect(){
       log.info("afterAspect....");
    }

    @Around("cut()")
    public void aroundAspect(ProceedingJoinPoint joinPoint){
       log.info("aroundAspect before......");
        try {
            // 毁掉目标对象原有方法
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("aroundAspect end......");
    }

}
