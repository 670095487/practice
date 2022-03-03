package com.example.dockerdemo.common;

import com.example.dockerdemo.exception.TestException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2021/11/04
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(TestException.class)
    public String testGlobalException(TestException exception){
        System.out.println("catch this : testException ");
        return exception.getMsg();
    }

    @ExceptionHandler(Throwable.class)
    public String testGlobalException(Throwable throwable){
        System.out.println("catch this : unexpect exception ->  " + Arrays.toString(throwable.getStackTrace()) + throwable.getMessage());
        return throwable.getMessage();
    }
}
