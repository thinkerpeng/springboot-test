package com.pwx.spring.mvc.dao;

import com.pwx.spring.mvc.entity.User;
import com.pwx.spring.mvc.model.UserModel;

import java.util.List;

/**
 * User DAO接口
 * Created by pengweixiang on 2018/9/17.
 */
public interface UserDao {

    int insertUser(UserModel record);

    User selectUser(String id);

    int updateUser(UserModel userModel);

    int deleteUser(String id);

    List<User> selectUsers();
}
