package com.emazon.microservice_stock.adapter.out.errorhandler;


import com.emazon.microservice_stock.domain.constant.category.CategoryBusinessRules;
import com.emazon.microservice_stock.domain.exception.category.CategoryDescriptionMaxSizeExceeded;
import com.emazon.microservice_stock.domain.exception.category.CategoryNameExists;
import com.emazon.microservice_stock.domain.exception.category.CategoryNameMaxSizeExceeded;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisorCategories {
    private static final String MESSAGE = "Message";
    private static final String STATUS = "Status";
    private static final String TIMESTAMP = "TimeStamp";

    @ExceptionHandler(CategoryNameMaxSizeExceeded.class)
    public ResponseEntity<Map<String,String>> categoryNameMaxSizeExceeded(
            CategoryNameMaxSizeExceeded categoryNameMaxSizeExceeded){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, categoryNameMaxSizeExceeded.getMessage());
        errorDetails.put(STATUS, HttpStatus.CONFLICT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(CategoryNameExists.class)
    public ResponseEntity<Map<String,String>> categoryNameExists(
            CategoryNameExists categoryNameExists){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, categoryNameExists.getMessage());
        errorDetails.put(STATUS, HttpStatus.CONFLICT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(CategoryDescriptionMaxSizeExceeded.class)
    public ResponseEntity<Map<String,String>> categoryDescriptionMaxSizeExceeded(
            CategoryDescriptionMaxSizeExceeded categoryDescriptionMaxSizeExceeded){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, categoryDescriptionMaxSizeExceeded.getMessage());
        errorDetails.put(STATUS, HttpStatus.CONFLICT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationException(MethodArgumentNotValidException ex){
        Map<String, String> errorDetails = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            errorDetails.put(((FieldError)error).getField(),error.getDefaultMessage());
            errorDetails.put(STATUS,HttpStatus.BAD_REQUEST.toString());
            errorDetails.put(TIMESTAMP,LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
