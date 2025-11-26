package com.emazon.microservice_stock.domain.service;

import com.emazon.microservice_stock.domain.model.Categories;
import com.emazon.microservice_stock.domain.port.out.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateCategoriesServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CreateCategoriesService service;

    @Test
    void createCategory() {
        String name = "Sport";
        String description = "Sport equipment";

        service.createCategory(name,description);
        verify(categoryRepository).saveCategoryDb(any(Categories.class));

    }

    @Test
    void findAllCategories() {
        int page = 0;
        int size = 10;
        String sortBy = "name";
        String address = "asc";
        service.findAllCategories(page, size, sortBy, address);
        verify(categoryRepository)
                .findAllCategories(page, size, sortBy, address);
    }
}