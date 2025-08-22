package com.emazon.microservice_stock.domain.constant.category;

public enum CategoryErrorMessage {
    CATEGORY_NAME_MAX_SIZE("You exceeded the maximum number of characters for the category name."),
    CATEGORY_NAME_EXISTS("Category name already exists in the database"),
    CATEGORY_DESCRIPTION_MAX_SIZE("You exceeded the maximum number of characters for the category description.");
    private String message;

    CategoryErrorMessage(String message){ this.message = message;}

    public String getMessage() {
        return message;
    }
}
