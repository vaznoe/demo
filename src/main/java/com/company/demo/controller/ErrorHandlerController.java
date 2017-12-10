package com.company.demo.controller;

import com.company.demo.entity.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(Exception.class)
    public ErrorMessage handleException(Exception exception) {
        log.info("Handle Exception");
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setDate(LocalDateTime.now());
        return errorMessage;
    }
}
