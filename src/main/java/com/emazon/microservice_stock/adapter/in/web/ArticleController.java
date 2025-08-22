package com.emazon.microservice_stock.adapter.in.web;

import com.emazon.microservice_stock.adapter.ConstantApiResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.ArticleRequest;

import com.emazon.microservice_stock.adapter.in.web.dto.BrandResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.CategoryResponse;
import com.emazon.microservice_stock.domain.model.Article;
import com.emazon.microservice_stock.domain.port.in.CreateArticleUseCase;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private final CreateArticleUseCase createArticleUseCase;


    public ArticleController(CreateArticleUseCase createArticleUseCase) {
        this.createArticleUseCase = createArticleUseCase;
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createArticle(@RequestBody ArticleRequest articleRequest){
        createArticleUseCase.createArticle(articleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(ConstantApiResponse.CREATED_ARTICLE_SUCCESS.getMessage(),
                HttpStatus.CREATED.value()));
    }

    @GetMapping("all")
    public ResponseEntity<Page<Article<CategoryResponse,BrandResponse>>> findAllPageArticles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String address
    ){
        return ResponseEntity.ok(createArticleUseCase.findAllArticles(page, size, sortBy, address));
    }
}
