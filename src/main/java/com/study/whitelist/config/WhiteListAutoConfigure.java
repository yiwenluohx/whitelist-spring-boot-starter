package com.study.whitelist.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 白名单自动注入
 *
 * @author luohx
 * @version 1.0.0
 * @date: 2022/11/8 上午10:37
 * @menu 白名单自动注入
 */
@Configuration
/**
 * 该注解可以用在类及方法上；类指的是标有@Configuration的类，方法是标有@Bean的方法；
 * @ConditionalOnClass注解的作用是当项目中存在某个类时才会使标有该注解的类或方法生效；
 */
@ConditionalOnClass(WhiteListProperties.class)
/**
 * 开启@ConfigurationProperties
 * 所以会在@ConfigurationProperties前面加上@Compent或@Configuration
 */
@EnableConfigurationProperties(WhiteListProperties.class)
public class WhiteListAutoConfigure {

    /**
     * properties 配置会被注入进来，当然你也可以选择使用 @Autowired 的方式配置注入在使用属性。
     * 整个方法会在配置信息和Bean注册完成后，开始被实例化加载到 Spring 中。
     *
     * @param properties
     * @return
     * @ConditionalOnMissingBean，现在就用到了这个方法上，代表只会实例化一个 Bean 对象。
     */
    @Bean("whiteListConfig")
    @ConditionalOnMissingBean
    public String whiteListConfig(WhiteListProperties properties) {
        return properties.getUsers();
    }
}
