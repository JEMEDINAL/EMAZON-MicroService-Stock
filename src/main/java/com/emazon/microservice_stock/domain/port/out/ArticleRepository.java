package com.emazon.microservice_stock.domain.port.out;

import com.emazon.microservice_stock.adapter.in.web.dto.BrandResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.CategoryResponse;
import com.emazon.microservice_stock.domain.model.Article;
import org.springframework.data.domain.Page;


public interface ArticleRepository {
    void articleSave(Article<Long,Long> article);
    Page<Article<CategoryResponse, BrandResponse>> findAllArticles(int page, int size ,String sortBy,String address);
}
