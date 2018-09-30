package com.pwx.spring.mvc.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by pengweixiang on 2018/9/16.
 */
@Component
@ConfigurationProperties(prefix = "test.weather")
public class WeatherSettings {

    private String city;
    private String jsonurl;
    private String xmlurl;

    @Override
    public String toString() {
        return "WeatherSettings{" +
                "city='" + city + '\'' +
                ", jsonurl='" + jsonurl + '\'' +
                ", xmlurl='" + xmlurl + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJsonurl() {
        return jsonurl;
    }

    public void setJsonurl(String jsonurl) {
        this.jsonurl = jsonurl;
    }

    public String getXmlurl() {
        return xmlurl;
    }

    public void setXmlurl(String xmlurl) {
        this.xmlurl = xmlurl;
    }
}
