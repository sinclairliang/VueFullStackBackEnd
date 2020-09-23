package com.evan.wj.exception;

import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class DefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        String message = null;

        if (e instanceof IllegalArgumentException) {
            message = "Illegal Arguments";
        }

        if (e instanceof MethodArgumentNotValidException) {
            message = ((MethodArgumentNotValidException) e)
                    .getBindingResult()
                    .getFieldError()
                    .getDefaultMessage();
        }

        if (e instanceof UnauthorizedException) {
            message = "Unauthorized Exception";
        }
        return ResultFactory.buildFailResult(message);
    }
}
