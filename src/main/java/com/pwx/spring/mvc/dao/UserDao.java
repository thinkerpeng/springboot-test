package com.pwx.spring.mvc.dao;

import com.pwx.spring.mvc.model.UserModel;

import java.util.List;

/**
 * User DAO接口
 * Created by pengweixiang on 2018/9/17.
 */
public interface UserDao {

    int insert(UserModel record);

    List<UserModel> selectUsers();
}
