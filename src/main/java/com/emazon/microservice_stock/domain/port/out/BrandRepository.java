package com.emazon.microservice_stock.domain.port.out;

import com.emazon.microservice_stock.domain.model.Brand;
import org.springframework.data.domain.Page;

public interface BrandRepository {
    void createBrand(Brand brand);
    Page<Brand> findAllBrand(int page, int size ,String sortBy,String address);
}
