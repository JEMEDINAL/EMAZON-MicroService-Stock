package com.emazon.microservice_stock.domain.service;

import com.emazon.microservice_stock.adapter.in.web.ApiResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.ArticleDtoResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.ArticleRequest;
import com.emazon.microservice_stock.domain.model.Article;
import com.emazon.microservice_stock.domain.port.in.CreateArticleUseCase;
import com.emazon.microservice_stock.domain.port.out.ArticleRepository;
import org.springframework.data.domain.Page;


public class CreateArticleService implements CreateArticleUseCase {
    private final ArticleRepository articleRepository;

    public CreateArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void createArticle(ArticleRequest articleRequest) {
        articleRepository.articleSave(new Article(
                articleRequest.getName(),
                articleRequest.getStock(),
                articleRequest.getPrice(),
                articleRequest.getBrand(),
                articleRequest.getCategories()
        ));
    }

    @Override
    public Page<ArticleDtoResponse> findAllArticles(int page, int size, String sortBy, String address) {
        return articleRepository.findAllArticles(page, size, sortBy, address);
    }

    @Override
    public ApiResponse searchToNameArticle(String article, int stock) {
        return articleRepository.searchToNameArticle(article,stock);
    }
}
