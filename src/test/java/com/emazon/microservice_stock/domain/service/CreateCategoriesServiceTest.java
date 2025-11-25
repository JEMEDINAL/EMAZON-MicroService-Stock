package com.emazon.microservice_stock.domain.service;

import com.emazon.microservice_stock.domain.model.Categories;
import com.emazon.microservice_stock.domain.port.out.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateCategoriesServiceTest {
    //crear una instancia falsa de esta clase

    // crea una instancia real y le inyecta el mock falso

    @Test
    void createCategory() {


    }

    @Test
    void findAllCategories() {


    }
}