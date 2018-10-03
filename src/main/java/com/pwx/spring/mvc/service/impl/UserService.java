package com.pwx.spring.mvc.service.impl;

import com.github.pagehelper.PageInfo;
import com.pwx.spring.mvc.entity.User;
import com.pwx.spring.mvc.model.UserModel;

/**
 * Created by pengweixiang on 2018/9/17.
 */
public interface UserService {

    int addUser(UserModel userModel);

    User findUser(String id);

    int updateUser(UserModel userModel);

    int deleteUser(String id);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
