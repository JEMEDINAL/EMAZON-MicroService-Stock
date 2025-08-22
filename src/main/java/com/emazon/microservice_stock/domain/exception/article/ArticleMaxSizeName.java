package com.emazon.microservice_stock.domain.exception.article;

import com.emazon.microservice_stock.domain.constant.article.ArticleErrorMessage;

public class ArticleMaxSizeName extends RuntimeException{
    public ArticleMaxSizeName() {
        super(ArticleErrorMessage.ARTICLE_ERROR_MAX_NAME.getMessage());
    }
}
