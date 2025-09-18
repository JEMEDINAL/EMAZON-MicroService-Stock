package com.emazon.microservice_stock.adapter.out.persistance.jpa;

import com.emazon.microservice_stock.adapter.in.web.ApiResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.BrandResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.CategoryResponse;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.ArticleEntity;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.BrandEntity;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.CategoriesEntity;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.mappers.ArticleMapper;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories.ArticleJpaRepository;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories.BrandJpaRepository;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories.CategoriesJpaRepository;
import com.emazon.microservice_stock.domain.exception.article.NoFoundBrand;
import com.emazon.microservice_stock.domain.exception.article.NoFoundCategory;
import com.emazon.microservice_stock.domain.model.Article;
import com.emazon.microservice_stock.domain.port.out.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JpaArticleRepository implements ArticleRepository {
    private final ArticleJpaRepository articleJpaRepository;
    private final ArticleMapper articleMapper;
    private final BrandJpaRepository brandJpaRepository;
    private final CategoriesJpaRepository categoriesJpaRepository;


    @Override
    public void articleSave(Article<Long,Long> article) {
        Set<CategoriesEntity> categoriesEntitySet = article.getCategories().stream()
                .map(categoriesJpaRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        BrandEntity brand = brandJpaRepository.findById(article.getBrand()).orElseThrow(NoFoundBrand::new);
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setCategories(categoriesEntitySet);
        articleEntity.setName(article.getName());
        articleEntity.setStock(article.getStock());
        articleEntity.setPrice(article.getPrice());
        articleEntity.setBrand(brand);
        articleJpaRepository.save(articleEntity);
    }

    @Override
    public Page<Article<CategoryResponse, BrandResponse>> findAllArticles(int page, int size, String sortBy, String address) {
        Sort sort = null;
        if (address.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<ArticleEntity> articleEntityPage = articleJpaRepository.findAll(pageable);
        List<Article<CategoryResponse,BrandResponse>> articleList = articleMapper.articlesResponse(articleEntityPage.getContent());

        return new PageImpl<>(articleList,pageable,articleEntityPage.getTotalElements());
    }

    @Override
    public ApiResponse searchToNameArticle(String name,int stock) {
        ArticleEntity searchArticle = articleJpaRepository.findArticleEntityByName(name).orElse(null);
        if(searchArticle == null) {
            return new ApiResponse("No se encontro el articulo se agrega el nuevo",404);
        }
        searchArticle.setStock(searchArticle.getStock() + stock);
        articleJpaRepository.save(searchArticle);
        return new ApiResponse("Actualizado el articulo",200);

    }


}
