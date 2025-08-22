package com.emazon.microservice_stock.domain.exception.article;

import com.emazon.microservice_stock.domain.constant.article.ArticleErrorMessage;

public class NoFoundBrand extends RuntimeException{
    public NoFoundBrand(){
        super(ArticleErrorMessage.NO_FOUND_BRAND.getMessage());
    }
}
