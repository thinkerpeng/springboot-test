package com.pwx.spring.result;


/**
 * Created by pengweixiang on 2018/10/1.
 * 返回工具类
 */
public class ResultUtil {

    /**
     * 返回成功，传入返回体具体出參
     * @param object object
     * @return result
     */
    public static Result success(Object object) {
        return new Result(ResultStatusEnum.SUCCESS, object);
    }

    /**
     * 提供给部分不需要出參的接口
     * @return result
     */
    public static Result success(){
        return new Result(ResultStatusEnum.SUCCESS, null);
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param statusEnum statusEnum
     * @return result
     */
    public static Result error(ResultStatusEnum statusEnum){
        return new Result(statusEnum, null);
    }

    /**
     * 自定义错误信息
     * @param status status
     * @param message message
     * @return
     */
    public static Result error(Integer status,String message){
        return new Result(status, message);
    }
}
