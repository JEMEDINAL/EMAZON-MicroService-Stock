package com.emazon.microservice_stock.adapter.out.errorhandler;

import com.emazon.microservice_stock.domain.exception.article.MaxRelatedCategories;
import com.emazon.microservice_stock.domain.exception.article.NoFoundCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisorArticle {
    private static final String MESSAGE = "Message";
    private static final String STATUS = "Status";
    private static final String TIMESTAMP = "TimeStamp";

    @ExceptionHandler(NoFoundCategory.class)
    public ResponseEntity<Map<String,String>> categoryNofound(
            NoFoundCategory noFoundCategory
    ){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE,noFoundCategory.getMessage());
        errorDetails.put(STATUS, HttpStatus.CONFLICT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(MaxRelatedCategories.class)
    public ResponseEntity<Map<String,String>> categoryMaxRelated(
            MaxRelatedCategories maxRelatedCategories
    ){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE,maxRelatedCategories.getMessage());
        errorDetails.put(STATUS, HttpStatus.CONFLICT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }
}
