package com.enotes.exception;

import com.enotes.AppResponse.ApiResponse;
import com.enotes.AppResponse.CategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotfoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response= new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

    }
}
