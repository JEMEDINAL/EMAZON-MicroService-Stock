package com.emazon.microservice_stock.adapter.in.web;

import com.emazon.microservice_stock.adapter.ConstantApiResponse;
import com.emazon.microservice_stock.adapter.in.web.dto.BrandRequest;
import com.emazon.microservice_stock.domain.model.Brand;
import com.emazon.microservice_stock.domain.port.in.CreateBrandUseCase;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    private final CreateBrandUseCase brandUseCase;

    public BrandController(CreateBrandUseCase brandUseCase) {
        this.brandUseCase = brandUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createBrand(@Valid @RequestBody BrandRequest brandRequest){
        brandUseCase.createBrand(brandRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(ConstantApiResponse.CREATE_BRAND_SUCCESS.getMessage(),HttpStatus.CREATED.value()));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Brand>> findAllBrands(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String address
    ){
        return ResponseEntity.ok(brandUseCase.findAllBrands(page, size, sortBy, address));
    }
}
