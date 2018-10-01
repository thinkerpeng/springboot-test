package com.pwx.spring.mvc.entity;

/**
 * Created by pengweixiang on 2018/10/1.
 * User实体类，后台传回给前台
 */
public class User {

    private String userId;
    private String userName;
    private String phone;

    public User() {}

    public User(String userId, String userName, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
