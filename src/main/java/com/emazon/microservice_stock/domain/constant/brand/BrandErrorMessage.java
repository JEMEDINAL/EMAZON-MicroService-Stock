package com.emazon.microservice_stock.domain.constant.brand;

public enum BrandErrorMessage {

    BRAND_NAME_MAX_SIZE("You have exceeded the number of characters allowed for your brand name."),
    BRAND_NAME_EXISTS("Your brand name already exists."),
    BRAND_DESCRIPTION_MAX_SIZE("You have exceeded the character limit for your brand description.");
    private String message;

    BrandErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
