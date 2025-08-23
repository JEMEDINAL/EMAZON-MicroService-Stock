package com.emazon.microservice_stock.domain.constant.category;

public final class CategoryBusinessRules {
    private CategoryBusinessRules(){

    }
    public static final int MAX_CHARACTER_NAME = 50;
    public static final int MAX_CHARACTER_DESCRIPTION = 90;
    public static final String ACCESS_ROL = "CREATE";
    public static final String ACCESS_DENIED = "Access denied: You do not have the necessary permissions to perform this action.";
}
