package com.emazon.microservice_stock.domain.port.in;

import com.emazon.microservice_stock.adapter.in.web.ApiResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.ArticleDtoResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.ArticleRequest;
import org.springframework.data.domain.Page;


public interface CreateArticleUseCase {
    void createArticle(ArticleRequest articleRequest);

    Page<ArticleDtoResponse> findAllArticles(int page, int size, String sortBy, String address);

    ApiResponse searchToNameArticle(String article,int stock);
}
