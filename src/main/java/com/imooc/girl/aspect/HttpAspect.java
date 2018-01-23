package com.imooc.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
// @Before("execution(public * com.imooc.girl.controller.GirlController.*(..))")
//    public void log(){
//     System.out.println(123456);
// }
//@After("execution(public * com.imooc.girl.controller.GirlController.*(..))")
//    public void doafter(){
//    System.out.println(456123);
//}
    private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.girl.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void dobefore(JoinPoint joinPoint){
       ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request= attributes.getRequest();
       //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doafter(){

        logger.info("222222222222222222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
