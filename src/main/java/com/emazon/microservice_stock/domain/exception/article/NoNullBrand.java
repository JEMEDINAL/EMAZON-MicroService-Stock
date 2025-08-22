package com.emazon.microservice_stock.domain.exception.article;

import com.emazon.microservice_stock.domain.constant.article.ArticleErrorMessage;

public class NoNullBrand extends RuntimeException{
    public NoNullBrand(){
        super(ArticleErrorMessage.NO_NULL_BRAND.getMessage());
    }
}
