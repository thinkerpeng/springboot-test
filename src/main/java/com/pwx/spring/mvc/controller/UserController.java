package com.pwx.spring.mvc.controller;

import com.pwx.spring.mvc.model.UserModel;
import com.pwx.spring.mvc.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pengweixiang on 2018/9/19.
 * User接口控制类，遵循Rest风格
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }
}
