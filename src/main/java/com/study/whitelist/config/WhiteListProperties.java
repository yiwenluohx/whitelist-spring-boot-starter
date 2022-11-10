package com.study.whitelist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 获取白名单配置
 * 将配置文件转换成类对象，便于修改或者获取值。
 *
 * @author luohx
 * @version 1.0.0
 * @date: 2022/11/8 上午10:25
 * @menu 获取白名单配置
 */
@ConfigurationProperties(prefix = "study.whitelist")
public class WhiteListProperties {

    private String users;

    /**
     * Gets the value of users.
     *
     * @return the value of users
     */
    public String getUsers() {
        return users;
    }

    /**
     * Sets the users. *
     * <p>You can use getUsers() to get the value of users</p>
     * * @param users users
     */
    public void setUsers(String users) {
        this.users = users;
    }
}
