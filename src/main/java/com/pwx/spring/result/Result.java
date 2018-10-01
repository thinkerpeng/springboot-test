package com.pwx.spring.result;

/**
 * Created by pengweixiang on 2018/10/1.
 * controller请求的返回体
 */
public class Result<T> {

    private Integer status;

    private String message;

    private T data;

    public Result(){}

    public Result(Integer status, String message){
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public Result(ResultStatusEnum statusEnum, T data){
        this.status = statusEnum.getStatus();
        this.message = statusEnum.getMessage();
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
