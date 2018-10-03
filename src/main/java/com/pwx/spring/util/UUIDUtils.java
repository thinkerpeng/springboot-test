package com.pwx.spring.util;

import org.apache.commons.lang.StringUtils;
import org.safehaus.uuid.UUIDGenerator;

/**
 * Created by pengweixiang on 2018/10/3.
 * UUID生成工具类
 */
public class UUIDUtils {

    public static String getUUID() {
        UUIDGenerator uuidGenerator = UUIDGenerator.getInstance();
        return uuidGenerator.generateTimeBasedUUID().toString();
    }

    public static String getUUID32() {
        UUIDGenerator uuidGenerator = UUIDGenerator.getInstance();
        String uuid32 = uuidGenerator.generateTimeBasedUUID().toString();
        return StringUtils.replace(uuid32, "-", "");
    }
}
