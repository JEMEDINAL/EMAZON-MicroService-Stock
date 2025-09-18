package com.emazon.microservice_stock.domain.port.in;

import com.emazon.microservice_stock.adapter.in.web.ApiResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.ArticleRequest;
import com.emazon.microservice_stock.adapter.in.web.dto.BrandResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.CategoryResponse;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.ArticleEntity;
import com.emazon.microservice_stock.domain.model.Article;
import org.springframework.data.domain.Page;


public interface CreateArticleUseCase {
    void createArticle(ArticleRequest articleRequest);

    Page<Article<CategoryResponse, BrandResponse>> findAllArticles(int page, int size, String sortBy, String address);

    ApiResponse searchToNameArticle(String article,int stock);
}
