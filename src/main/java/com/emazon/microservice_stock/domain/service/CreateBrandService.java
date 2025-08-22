package com.emazon.microservice_stock.domain.service;

import com.emazon.microservice_stock.adapter.in.web.dto.BrandRequest;
import com.emazon.microservice_stock.domain.model.Brand;
import com.emazon.microservice_stock.domain.port.in.CreateBrandUseCase;
import com.emazon.microservice_stock.domain.port.out.BrandRepository;
import org.springframework.data.domain.Page;

public class CreateBrandService implements CreateBrandUseCase {

    private final BrandRepository brandRepository;

    public CreateBrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void createBrand(BrandRequest brandRequest) {

        brandRepository.createBrand(new Brand(brandRequest.getName(), brandRequest.getDescription()));
    }

    @Override
    public Page<Brand> findAllBrands(int page, int size, String sortBy, String address) {
        return brandRepository.findAllBrand(page, size, sortBy, address);
    }
}
