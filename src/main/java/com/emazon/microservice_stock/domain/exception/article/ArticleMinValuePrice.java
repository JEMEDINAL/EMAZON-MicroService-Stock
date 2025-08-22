package com.emazon.microservice_stock.domain.exception.article;

import com.emazon.microservice_stock.domain.constant.article.ArticleErrorMessage;

public class ArticleMinValuePrice extends RuntimeException{
    public ArticleMinValuePrice() {
        super(ArticleErrorMessage.ARTICLE_PRICE_NEGATIVE.getMessage());
    }
}
