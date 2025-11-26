package com.emazon.microservice_stock.domain.service;

import com.emazon.microservice_stock.adapter.in.web.dto.BrandRequest;
import com.emazon.microservice_stock.domain.model.Brand;
import com.emazon.microservice_stock.domain.port.out.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateBrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private CreateBrandService service;


    @Test
    void createbrand() {
        service.createBrand(new BrandRequest("Nike","Make TO EEUU"));
        verify(brandRepository).createBrand(any(Brand.class));
    }

    @Test
    void finaAllBrand() {
        int page = 0;
        int size = 10;
        String sortBy = "name";
        String address = "asc";

        service.findAllBrands(page,size,sortBy,address);
        verify(brandRepository).findAllBrand(page,size,sortBy,address);

    }
}