package com.example.demostagram.handler;

import com.example.demostagram.handler.ex.CustomApiException;
import com.example.demostagram.handler.ex.CustomException;
import com.example.demostagram.handler.ex.CustomValidationApiException;
import com.example.demostagram.handler.ex.CustomValidationException;
import com.example.demostagram.util.Script;
import com.example.demostagram.web.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    //자바스크립트 리턴
    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e){

        if (e.getErrorMap()==null){
            return Script.back(e.getMessage());
        }else{
            return Script.back(e.getErrorMap().toString());
        }

    }

    @ExceptionHandler(CustomException.class)
    public String validationException(CustomException e) {
        return Script.back(e.getMessage());
    }


    //데이터리턴
    @ExceptionHandler(CustomValidationApiException.class)
    public ResponseEntity<?> validationApiException(CustomValidationApiException e) {
        System.out.println("== validationApiException에러 ===========");
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException e) {
        System.out.println("== apiException에러 ===========");
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
    }



}
