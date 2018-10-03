package com.pwx.spring.mvc.controller;

import com.pwx.spring.mvc.entity.User;
import com.pwx.spring.mvc.model.UserModel;
import com.pwx.spring.mvc.model.WeatherSettings;
import com.pwx.spring.result.ExceptionHandle;
import com.pwx.spring.result.Result;
import com.pwx.spring.result.ResultStatusEnum;
import com.pwx.spring.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by pengweixiang on 2018/9/16.
 */
@Controller
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherSettings weatherSettings;

    @Autowired
    private ExceptionHandle exceptionHandle;

    //输入http://localhost:8080，重定向到/index
    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        LOGGER.info("enter {}", "index");
        weatherSettings.setJsonurl(String.format(weatherSettings.getJsonurl(), weatherSettings.getCity()));
        weatherSettings.setXmlurl(String.format(weatherSettings.getXmlurl(), weatherSettings.getCity()));
        model.addAttribute("weatherSettings", weatherSettings);
        return "index";
    }

    @ResponseBody
    @RequestMapping("setting")
    public WeatherSettings setting() {
        LOGGER.info("enter {}", "setting");
        weatherSettings.setJsonurl(String.format(weatherSettings.getJsonurl(), weatherSettings.getCity()));
        weatherSettings.setXmlurl(String.format(weatherSettings.getXmlurl(), weatherSettings.getCity()));
        return weatherSettings;
    }

}
