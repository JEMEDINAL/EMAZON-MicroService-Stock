package com.emazon.microservice_stock.adapter.out.persistance.jpa.mappers;

import com.emazon.microservice_stock.adapter.in.web.dto.BrandResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.CategoryResponse;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.ArticleEntity;
import com.emazon.microservice_stock.domain.model.Article;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    //ArticleEntity articleToArticleEntity(Article<Long,Long> article);
    default List<Article<CategoryResponse, BrandResponse>> articlesResponse(List<ArticleEntity> articleEntities){
        return articleEntities.stream()
                .map(articleEntity -> {
                    Article<CategoryResponse,BrandResponse> article = new Article<>();
                    BrandResponse brandResponse = new BrandResponse();
                    Set<CategoryResponse> categoryResponses = new HashSet<>();
                    article.setName(articleEntity.getName());
                    article.setStock(articleEntity.getStock());
                    article.setPrice(articleEntity.getPrice());
                    articleEntity.getCategories().stream()
                            .map(categoriesEntity -> new CategoryResponse(categoriesEntity.getId(), categoriesEntity.getName()))
                            .forEach(categoryResponses::add);
                    article.setCategories(categoryResponses);
                    brandResponse.setId(articleEntity.getId());
                    brandResponse.setName(articleEntity.getName());
                    article.setBrand(brandResponse);
                    return article;
                })
                .collect(Collectors.toList());
    }

}
