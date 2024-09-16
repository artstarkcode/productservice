package com.arjun.productservice.advices;

import com.arjun.productservice.dtos.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//This handler is applicable to all the controllers
@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRunTimeException(){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Something went wrong");
        errorResponseDto.setStatus("RUNTIME ERROR");
        return errorResponseDto;
    }
    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "something went wrong";
    }
}
