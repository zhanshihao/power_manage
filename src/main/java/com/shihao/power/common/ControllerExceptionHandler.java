package com.shihao.power.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**此注解用于标识此类为全局的异常处理类*/
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult handleException(Exception e){
        System.out.println("exception");
        e.printStackTrace();
        return new JsonResult(e);
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult handleException(RuntimeException e){
        System.out.println("runtime exception");
        e.printStackTrace();
        return new JsonResult(e);
    }
}
