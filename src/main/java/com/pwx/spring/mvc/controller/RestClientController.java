package com.pwx.spring.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pwx.spring.mvc.model.WeatherSettings;
import com.pwx.spring.util.RestClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.IOUtils;

import java.io.IOException;


/**
 * Created by pengweixiang on 2018/9/29.
 * Rest类型接口请求
 */
@RestController
@RequestMapping("/restclient")
public class RestClientController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestClientUtil restClientUtil;

    @Autowired
    private WeatherSettings weatherSettings;

    //加载静态json文件
    @Value("classpath:static/data/_city.json")
    private Resource weatherJson;

    @GetMapping("/weather")
    public String getWeather() {

        LOGGER.info("enter getWeather");
        String city_code = null;
        try {
            String json = new String(IOUtils.readFully(weatherJson.getInputStream(), -1, true));
            JSONArray jsonArray = JSON.parseArray(json);
            for (Object obj :
                    jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                if (jsonObject.getString("city_name").equals(weatherSettings.getCity())) {
                    city_code = jsonObject.getString("city_code");
                    LOGGER.info("getWeather city_name: {}, city_code: {}", weatherSettings.getCity(), city_code);
                }
            }
        } catch (IOException e) {
            LOGGER.error("Read file {} error", "_city.json");
            e.printStackTrace();
        }

        if (city_code == null) {
            LOGGER.error("city_code is null");
            return "city_code is null";
        }
        String uri = String.format(weatherSettings.getJsonurl(), city_code);
        ResponseEntity<String> responseEntity = restClientUtil.get(uri, String.class);
        if (responseEntity != null) {
            return responseEntity.getBody();
        }

        return "responseEntity is null";
    }
}
