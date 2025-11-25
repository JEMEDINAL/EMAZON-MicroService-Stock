package com.emazon.microservice_stock.domain.port.out;

import com.emazon.microservice_stock.adapter.in.web.ApiResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.ArticleDtoResponse;
import com.emazon.microservice_stock.domain.model.Article;
import org.springframework.data.domain.Page;


public interface ArticleRepository {
    void articleSave(Article article);
    Page<ArticleDtoResponse> findAllArticles(int page, int size , String sortBy, String address);
    ApiResponse searchToNameArticle(String article,int stock);
}
