package com.enotes.exception;

import com.enotes.AppResponse.ApiResponse;
import com.enotes.AppResponse.CategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotfoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response= new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        Map<String,String> resp = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach((error) -> {
//            String fieldName = error.getField();
//            String message = error.getDefaultMessage();
//            resp.put(fieldName, message);
//        });
//        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
//        ApiResponse apiResponse = new ApiResponse(message, false);
//        return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException ex) {
        return new ResponseEntity<>(ex.getErrors(),HttpStatus.BAD_REQUEST);
    }
}
