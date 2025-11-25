package com.emazon.microservice_stock.domain.port.in;

import com.emazon.microservice_stock.adapter.in.web.dto.BrandRequest;
import com.emazon.microservice_stock.adapter.in.web.dto.BrandResponse;
import org.springframework.data.domain.Page;

public interface CreateBrandUseCase {

    void createBrand(BrandRequest brandRequest);

    Page<BrandResponse> findAllBrands(int page, int size, String sortBy, String address);
}
