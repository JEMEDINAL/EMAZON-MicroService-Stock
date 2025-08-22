package com.emazon.microservice_stock.adapter.in.web;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private String message;
    private int httpStatus;

    public ApiResponse(String message, int httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
