package com.study.whitelist.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义白名单注解
 *
 * @author luohx
 * @version 1.0.0
 * @date: 2022/11/8 上午10:13
 * @menu 自定义白名单注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoWhiteList {
    /**
     * 接口入参需要提取的属性
     *
     * @return
     */
    String key() default "";

    /**
     * 拦截到用户请求后需要返回的信息
     *
     * @return
     */
    String returnJson() default "";
}
