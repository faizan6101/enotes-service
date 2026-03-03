package com.enotes.util;

import com.enotes.handler.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonUtil {

    public static ResponseEntity<?> createBuildResponse(Object data,HttpStatus status){
        GenericResponse response=GenericResponse.builder()
                .responseStatus(status)
                .status("success")
                .message("success")
                .data(data)
                .build();
        return  response.create();
    }

    public static ResponseEntity<?> createBuildResponseMessage(Object data,String message, HttpStatus status){
        GenericResponse response=GenericResponse.builder()
                .responseStatus(status)
                .status("success")
                .message(message)
                .data(data)
                .build();
        return  response.create();
    }

    public static ResponseEntity<?> createErrorResponse(Object data, HttpStatus status){
        GenericResponse response=GenericResponse.builder()
                .responseStatus(status)
                .status("failed")
                .message("failed")
                .build();
        return  response.create();
    }
    public static ResponseEntity<?> createErrorResponseMessage(String message, HttpStatus status){
        GenericResponse response=GenericResponse.builder()
                .responseStatus(status)
                .status("failed")
                .message(message)
                .build();
        return  response.create();
    }


}
