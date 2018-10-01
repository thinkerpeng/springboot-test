package com.pwx.spring.mvc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pwx.spring.mvc.dao.UserDao;
import com.pwx.spring.mvc.model.UserModel;
import com.pwx.spring.mvc.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pengweixiang on 2018/9/17.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(UserModel user) {
        return userDao.insert(user);
    }

    @Override
    public PageInfo<UserModel> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<UserModel> userModels = userDao.selectUsers();
        PageInfo result = new PageInfo(userModels);
        return result;
    }
}
