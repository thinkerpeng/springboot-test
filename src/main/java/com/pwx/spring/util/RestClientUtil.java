package com.pwx.spring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by pengweixiang on 2018/9/29.
 * Http 请求公共类
 */
@Component
public class RestClientUtil {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    /**
     * get方法请求
     * @param uri 请求地址
     * @param responseType 返回类型
     * @param <T> 泛型
     * @return 返回实体
     */
    public <T> ResponseEntity<T> get(String uri, Class<T> responseType) {

        ResponseEntity<T> responseEntity = null;

        try {
            LOGGER.info("URI : {}", uri);
            RequestEntity requestEntity = RequestEntity.get(new URI(uri)).build();
            responseEntity = restTemplate.exchange(requestEntity, responseType);
        } catch (URISyntaxException e) {
            LOGGER.error("URI: {} is invalid", uri);
            e.printStackTrace();
        }
        return responseEntity;
    }
}
