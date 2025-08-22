package com.emazon.microservice_stock.adapter.in.web;

import com.emazon.microservice_stock.domain.port.in.CreateCategoriesUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CatecoriesControllerTest {
    @Mock
    private CreateCategoriesUseCase createCategoriesUseCase;

    @InjectMocks
    private CatecoriesController catecoriesController;

    @Test
    void createCategories() {

    }

    @Test
    void findAllPageCategories() {
    }
}