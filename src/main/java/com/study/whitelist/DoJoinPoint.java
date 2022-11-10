package com.study.whitelist;

import com.alibaba.fastjson.JSON;
import com.study.whitelist.annotation.DoWhiteList;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 切面逻辑实现
 *
 * @author luohx
 * @version 1.0.0
 * @Aspect 定义切面类
 * @Component 将类生成为Bean对象
 * @date: 2022/11/8 上午11:14
 * @menu 切面逻辑实现
 */
@Aspect
@Component
public class DoJoinPoint {

    private Logger logger = LoggerFactory.getLogger(DoJoinPoint.class);

    @Resource
    private String whiteListConfig;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.study.whitelist.annotation.DoWhiteList)")
    public void aopPoint() {
    }

    /**
     * 拦截操作
     *
     * @param jp
     * @return
     * @throws Throwable
     * @Around("aopPoint()")，可以理解为是对方法增强的织入动作
     */
    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint jp) throws Throwable {
        Method method = this.getMethod(jp);
        DoWhiteList whiteList = method.getAnnotation(DoWhiteList.class);
        String keyValue = this.getFiledValue(whiteList.key(), jp.getArgs());
        logger.info("middleware whitelist handler method：{} value：{}", method.getName(), keyValue);
        if (StringUtils.isEmpty(keyValue)) return jp.proceed();
        String[] split = whiteListConfig.split(",");
        //白名单过滤
        for (String str : split) {
            if (keyValue.equals(str)) {
                return jp.proceed();
            }
        }
        //拦截
        return this.returnObject(whiteList, method);
    }

    /**
     * 返回对象
     *
     * @param whiteList
     * @param method
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private Object returnObject(DoWhiteList whiteList, Method method) throws IllegalAccessException, InstantiationException {
        Class<?> returnType = method.getReturnType();
        String returnJson = whiteList.returnJson();
        if ("".equals(returnJson)) {
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    /**
     * 获取属性值
     *
     * @param filed
     * @param args
     * @return
     */
    private String getFiledValue(String filed, Object[] args) {
        String filedValue = null;
        for (Object arg : args) {
            try {
                if (null == filedValue || "".equals(filedValue)) {
                    filedValue = BeanUtils.getProperty(arg, filed);
                } else {
                    break;
                }
            } catch (Exception e) {
                if (args.length == 1) {
                    return args[0].toString();
                }
            }
        }
        return filedValue;
    }
}
