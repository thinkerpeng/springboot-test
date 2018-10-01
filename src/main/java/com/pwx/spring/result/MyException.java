package com.pwx.spring.result;

/**
 * Created by pengweixiang on 2018/10/1.
 * 自定义异常类
 */
public class MyException extends RuntimeException {

    private Integer status;

    /**
     * 继承exception，加入错误状态值
     * @param statusEnum statusEnum
     */
    public MyException(ResultStatusEnum statusEnum){
        super(statusEnum.getMessage());
        this.status = statusEnum.getStatus();
    }

    /**
     * 自定义错误信息
     * @param message message
     * @param status status
     */
    public MyException(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
