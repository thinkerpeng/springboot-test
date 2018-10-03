package com.pwx.spring.mvc.model;

import org.hibernate.validator.constraints.NotBlank;


/**
 * User模型类，前台传入后台
 * Created by pengweixiang on 2018/9/17.
 */
public class UserModel {

    private String id;
    private String userName;
    private String password;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotBlank(message = "userName can not be empty!")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotBlank(message = "password can not be empty!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //自定义注解
    @Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
