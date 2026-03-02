package com.enotes.util;

import com.enotes.dto.CategoryDto;
import com.enotes.exception.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class Validation {

    public void  categoryValidation(CategoryDto categoryDto){
        Map<String, Object> error=new LinkedHashMap<>();


    if (ObjectUtils.isEmpty(categoryDto)){
        throw  new IllegalArgumentException("category object/JSON should not be null or empty");

        //validation field name
    }else if(ObjectUtils.isEmpty(categoryDto.getName())){
        error.put("name","name field is empty or null");
        } else if (categoryDto.getName().length()<3) {
            error.put("name"," name length min 3");
        } else if (categoryDto.getName().length()>100){
            error.put("name"," name length max 100");
        }

    //validation field description
    else if(ObjectUtils.isEmpty(categoryDto.getDescription())){
        error.put("description","description field is empty or null");
    } else if (categoryDto.getDescription().length()<10) {
        error.put("description"," description length min 10");
    } else if (categoryDto.getDescription().length()>100){
        error.put("description"," description length max 100");
    }

    //validation isActive
    else if(ObjectUtils.isEmpty(categoryDto.getIsActive())){
        error.put("isActive","isActive field is empty or null");
    }
    else if (categoryDto.getIsActive() != Boolean.TRUE.booleanValue()
            && categoryDto.getIsActive() != Boolean.FALSE.booleanValue()) {
        error.put("isActive","isActive field is invalid");
    }
if(!error.isEmpty()){
    throw new ValidationException(error);
}
    }

    }

