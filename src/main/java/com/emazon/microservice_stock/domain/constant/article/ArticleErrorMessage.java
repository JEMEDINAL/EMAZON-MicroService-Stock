package com.emazon.microservice_stock.domain.constant.article;

public enum ArticleErrorMessage {
    ARTICLE_ERROR_MAX_NAME("You have reached the maximum number of characters for the name, or the name field is empty."),
    ARTICLE_STOCK_NEGATIVE("The stock field cannot be negative."),
    ARTICLE_PRICE_NEGATIVE("Negative values are not accepted for the price of the item."),
    MAX_RELATED_CATEGORIES("There cannot be more than 3 categories related to your article."),
    NO_NULL_BRAND("There must be a brand related to your article."),
    NO_FOUND_CATEGORY_EXISTS("This category has not been found."),
    NO_FOUND_BRAND("This brand has not been found.");


    private String message;
    ArticleErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
