package com.emazon.microservice_stock.adapter;

public enum ConstantApiResponse {
    CREATED_CATEGORY_SUCCESS("You have successfully created your category."),
    CREATED_ARTICLE_SUCCESS("You have successfully created your article."),
    CREATE_BRAND_SUCCESS("Your brand was successfully created.");
    private String message;


    ConstantApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
