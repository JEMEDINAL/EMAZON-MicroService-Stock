package com.emazon.microservice_stock.domain.exception.article;

import com.emazon.microservice_stock.domain.constant.article.ArticleErrorMessage;

public class MaxRelatedCategories extends RuntimeException{
    public MaxRelatedCategories(){
        super(ArticleErrorMessage.MAX_RELATED_CATEGORIES.getMessage());
    }
}
