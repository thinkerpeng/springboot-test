package com.pwx.spring.mvc.service.impl;

import com.github.pagehelper.PageInfo;
import com.pwx.spring.mvc.model.UserDomain;

/**
 * Created by pengweixiang on 2018/9/17.
 */
public interface UserService {

    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}
