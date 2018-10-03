package com.pwx.spring.result;

/**
 * Created by pengweixiang on 2018/10/1.
 * 返回类型枚举类
 */
public enum ResultStatusEnum {

    // 系统错误
    INTERNAL_ERROR(500001, "Internal error"),

    // 200成功
    SUCCESS(200, "Success"),

    // 400异常
    URI_NOT_EXIST(404001, "Uri is not exist"),
    USER_NOT_FOUND(404002, "User is not exist"),
    PARAMETER_IS_INVALID(404003, "User parameter is invalid"),
    USER_ADD_ERROR(404004, "Add User failed"),
    USER_UPDATE_ERROR(404005, "Update User failed")
    ;

    private Integer status;

    private String message;

    ResultStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
