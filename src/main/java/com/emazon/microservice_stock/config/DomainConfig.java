package com.emazon.microservice_stock.config;

import com.emazon.microservice_stock.domain.port.in.CreateArticleUseCase;
import com.emazon.microservice_stock.domain.port.in.CreateBrandUseCase;
import com.emazon.microservice_stock.domain.port.in.CreateCategoriesUseCase;
import com.emazon.microservice_stock.domain.port.out.ArticleRepository;
import com.emazon.microservice_stock.domain.port.out.BrandRepository;
import com.emazon.microservice_stock.domain.port.out.CategoryRepository;
import com.emazon.microservice_stock.domain.service.CreateArticleService;
import com.emazon.microservice_stock.domain.service.CreateBrandService;
import com.emazon.microservice_stock.domain.service.CreateCategoriesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    public CreateArticleUseCase createArticleUseCase(ArticleRepository articleRepository){
        return new CreateArticleService(articleRepository);
    }

    @Bean
    public CreateCategoriesUseCase createCategoriesUseCase(CategoryRepository categoryRepository){
        return new CreateCategoriesService(categoryRepository);
    }

    @Bean
    public CreateBrandUseCase createBrandUseCase(BrandRepository brandRepository){
        return new CreateBrandService(brandRepository);
    }
}
