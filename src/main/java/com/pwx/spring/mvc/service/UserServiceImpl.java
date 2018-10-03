package com.pwx.spring.mvc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pwx.spring.mvc.dao.UserDao;
import com.pwx.spring.mvc.entity.User;
import com.pwx.spring.mvc.model.UserModel;
import com.pwx.spring.mvc.service.impl.UserService;
import com.pwx.spring.util.UUIDUtils;
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
    public int addUser(UserModel userModel) {
        String uuid32 = UUIDUtils.getUUID32();
        userModel.setId(uuid32);
        return userDao.insertUser(userModel);
    }

    @Override
    public User findUser(String id) {
        return userDao.selectUser(id);
    }

    @Override
    public int updateUser(UserModel userModel) {
        return userDao.updateUser(userModel);
    }

    @Override
    public int deleteUser(String id) {
        return userDao.deleteUser(id);
    }

    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.selectUsers();
        PageInfo<User> result = new PageInfo(users);
        return result;
    }
}
