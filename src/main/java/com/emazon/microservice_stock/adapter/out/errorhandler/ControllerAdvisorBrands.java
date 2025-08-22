package com.emazon.microservice_stock.adapter.out.errorhandler;

import com.emazon.microservice_stock.domain.exception.brand.BrandDescriptionMaxSizeExceeded;
import com.emazon.microservice_stock.domain.exception.brand.BrandNameExists;
import com.emazon.microservice_stock.domain.exception.brand.BrandNameMaxSizeExceeded;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisorBrands {
    private static final String MESSAGE = "Message";
    private static final String STATUS = "Status";
    private static final String TIMESTAMP = "TimeStamp";

    @ExceptionHandler(BrandNameMaxSizeExceeded.class)
    public ResponseEntity<Map<String,String>> brandNameMaxSizeExceeded(
            BrandNameMaxSizeExceeded brandNameMaxSizeExceeded
    ){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, brandNameMaxSizeExceeded.getMessage());
        errorDetails.put(STATUS, HttpStatus.CONFLICT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(BrandDescriptionMaxSizeExceeded.class)
    public ResponseEntity<Map<String,String>> brandDescriptionMaxSizeExceeded(
            BrandDescriptionMaxSizeExceeded brandDescriptionMaxSizeExceeded
    ){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, brandDescriptionMaxSizeExceeded.getMessage());
        errorDetails.put(STATUS, HttpStatus.CONFLICT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(BrandNameExists.class)
    public ResponseEntity<Map<String,String>> brandNameExists(
            BrandNameExists brandNameExists
    ){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, brandNameExists.getMessage());
        errorDetails.put(STATUS, HttpStatus.CONFLICT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }
}
