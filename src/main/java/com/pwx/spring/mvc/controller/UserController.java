package com.pwx.spring.mvc.controller;

import com.pwx.spring.mvc.model.UserDomain;
import com.pwx.spring.mvc.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pengweixiang on 2018/9/19.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int addUser(UserDomain user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }
}
