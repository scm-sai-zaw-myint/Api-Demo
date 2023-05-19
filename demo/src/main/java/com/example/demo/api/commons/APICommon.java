package com.example.demo.api.commons;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APICommon {

    public static Map<String,Object> getErrorMessages(BindingResult bindingResult) {
        Map<String, Object> data = new HashMap<>();
        List<String> errorMessages = new ArrayList<>();
        // Field errors
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String errorMessage = fieldError.getField() + ": " + fieldError.getDefaultMessage();
            errorMessages.add(errorMessage);
        }

        // Global errors
        for (ObjectError objectError : bindingResult.getGlobalErrors()) {
            String errorMessage = objectError.getDefaultMessage();
            errorMessages.add(errorMessage);
        }
        data.put("errors", errorMessages);
        return data;
    }
}
