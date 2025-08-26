package com.emazon.microservice_stock.domain.constant.brand;

public final class BrandBusinessRules {
    private BrandBusinessRules(){

    }
    public static final int MAX_CHARACTER_NAME = 50;
    public static final int MAX_CHARACTER_DESCRIPTION = 120;
    public static final String NOT_ONLY_NUMBERS = "The brand name and description can only contain letters and spaces.";
}
