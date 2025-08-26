package com.emazon.microservice_stock.domain.constant.article;

public final class ArticleBusinessRules {
    private ArticleBusinessRules(){

    }
    public static final int MAX_VALUR_NAME = 60;
    public static final int MIN_VALUE_STOCK = 0;
    public static final int MIN_VALUE_PRICE = 0;
    public static final int MAX_VALUE_CATEGORIES = 3;
    public static final String NOT_ONLY_NUMBERS = "The name of the article can only contain letters and spaces.";

}
