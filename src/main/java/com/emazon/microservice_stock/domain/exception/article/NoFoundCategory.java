package com.emazon.microservice_stock.domain.exception.article;

import com.emazon.microservice_stock.domain.constant.article.ArticleErrorMessage;

public class NoFoundCategory extends RuntimeException{
    public NoFoundCategory(){
        super(ArticleErrorMessage.NO_FOUND_CATEGORY_EXISTS.getMessage());
    }
}
