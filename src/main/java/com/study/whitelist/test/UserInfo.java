package com.study.whitelist.test;

/**
 * @author luohx
 * @version 1.0.0
 * @date: 2022/11/9 下午5:51
 * @menu
 */
public class UserInfo {
    //code、info可以统一定义一个类
    private String code;
    private String info;

    private String name;
    private Integer age;
    private String address;

    public UserInfo() {

    }

    public UserInfo(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public UserInfo(String name, Integer age, String address) {
        this.code = "0000";
        this.info = "success";
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Gets the value of code.
     *
     * @return the value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code. *
     * <p>You can use getCode() to get the value of code</p>
     * * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the value of info.
     *
     * @return the value of info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the info. *
     * <p>You can use getInfo() to get the value of info</p>
     * * @param info info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Gets the value of name.
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name. *
     * <p>You can use getName() to get the value of name</p>
     * * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of age.
     *
     * @return the value of age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age. *
     * <p>You can use getAge() to get the value of age</p>
     * * @param age age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Gets the value of address.
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address. *
     * <p>You can use getAddress() to get the value of address</p>
     * * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
