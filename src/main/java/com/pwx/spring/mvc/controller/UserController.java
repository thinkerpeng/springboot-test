package com.pwx.spring.mvc.controller;

import com.pwx.spring.mvc.model.UserModel;
import com.pwx.spring.mvc.service.impl.UserService;
import com.pwx.spring.result.Result;
import com.pwx.spring.result.ResultStatusEnum;
import com.pwx.spring.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by pengweixiang on 2018/9/19.
 * User接口控制类，Rest风格
 */
@RestController
@RequestMapping(value = "/v1.0")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Result addUser(@RequestBody @Valid UserModel userModel) {
        int result = userService.addUser(userModel);
        if (result != 1) {
            LOGGER.error("add user failed. userName={}", userModel.getUserName());
            return ResultUtil.error(ResultStatusEnum.USER_ADD_ERROR);
        } else {
            LOGGER.info("add user success, userName={}", userModel.getUserName());
            return ResultUtil.success(userService.findUser(userModel.getId()));
        }
    }

    @PutMapping("/user/{id}")
    public Result updateUser(@PathVariable("id") String id, @RequestBody @Valid UserModel userModel){
        userModel.setId(id);
        int result = userService.updateUser(userModel);
        if (result != 1) {
            LOGGER.error("update user failed. userName={}", userModel.getUserName());
            return ResultUtil.error(ResultStatusEnum.USER_UPDATE_ERROR);
        } else {
            LOGGER.info("update user success, userName={}", userModel.getUserName());
            return ResultUtil.success();
        }
    }

    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable("id") String id) {
        int result = userService.deleteUser(id);
        if (result == 0) {
            LOGGER.error("delete user failed. user is not exist, id={}", id);
            return ResultUtil.error(ResultStatusEnum.USER_NOT_FOUND);
        } else {
            LOGGER.info("delete user success, id={}", id);
            return ResultUtil.success();
        }
    }

    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable("id") String id) {
        return ResultUtil.success(userService.findUser(id));
    }

    @GetMapping("/user")
    public Result findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return ResultUtil.success(userService.findAllUser(pageNum, pageSize));
    }
}
