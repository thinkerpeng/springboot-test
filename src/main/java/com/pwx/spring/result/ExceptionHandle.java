package com.pwx.spring.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pengweixiang on 2018/10/1.
 * controller切面异常处理类
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e exception
     * @return result
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e) {

        //已知的异常信息
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getStatus(), myException.getMessage());
        }

        //未知的异常信息
        LOGGER.error("Internal error: {}", e);
        return ResultUtil.error(ResultStatusEnum.INTERNAL_ERROR);
    }
}
