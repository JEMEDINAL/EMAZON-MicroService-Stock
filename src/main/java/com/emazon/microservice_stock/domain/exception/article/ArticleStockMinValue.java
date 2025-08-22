package com.emazon.microservice_stock.domain.exception.article;

import com.emazon.microservice_stock.domain.constant.article.ArticleErrorMessage;

public class ArticleStockMinValue extends RuntimeException{
    public ArticleStockMinValue() {
        super(ArticleErrorMessage.ARTICLE_STOCK_NEGATIVE.getMessage());
    }
}
