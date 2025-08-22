package com.emazon.microservice_stock.adapter.in.web;

import com.emazon.microservice_stock.adapter.ConstantApiResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.CategoriesRequest;
import com.emazon.microservice_stock.domain.model.Categories;
import com.emazon.microservice_stock.domain.port.in.CreateCategoriesUseCase;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CatecoriesController {
    private final CreateCategoriesUseCase createCategoriesUseCase;

    public CatecoriesController(CreateCategoriesUseCase createCategoriesUseCase) {
        this.createCategoriesUseCase = createCategoriesUseCase;

    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategories(@RequestBody CategoriesRequest categoriesRequest){

        createCategoriesUseCase.createCategory(categoriesRequest.getName(), categoriesRequest.getDescription());

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(ConstantApiResponse.CREATED_CATEGORY_SUCCESS.getMessage(),HttpStatus.CREATED.value()));
    }

    @GetMapping("all")
    public ResponseEntity<Page<Categories>> findAllPageCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String address
    ){
        return ResponseEntity.ok(createCategoriesUseCase.findAllCategories(page, size, sortBy, address));
    }
}
