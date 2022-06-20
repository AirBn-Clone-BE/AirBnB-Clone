package com.sparta.airbnb_clone.exception;

<<<<<<< HEAD
import com.sparta.airbnb_clone.dto.ResponseDto;
=======
import com.sparta.airbnb_clone.model.dto.ResponseDto;
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {CustomErrorException.class})
    public ResponseEntity<Object> handleApiRequestException(RuntimeException ex) {
        ResponseDto restApiException = new ResponseDto("fail",ex.getMessage(),"");

        return new ResponseEntity<>(
                restApiException,
                HttpStatus.BAD_REQUEST
        );
    }
}
