package com.arjun.productservice.advices;


import com.arjun.productservice.dtos.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

//This handler is applicable to all the controllers
@ControllerAdvice
@RestController
public class ExceptionAdvices {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRunTimeException(RuntimeException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Run time exception caught. Something went wrong");
        errorResponseDto.setStatus(e.getMessage());
        return errorResponseDto;
    }
    @ExceptionHandler(Exception.class)
    public ErrorResponseDto handleException(Exception e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Standard exception caught. Something went wrong. ");
        errorResponseDto.setStatus(e.getMessage());
        return errorResponseDto;
    }
}