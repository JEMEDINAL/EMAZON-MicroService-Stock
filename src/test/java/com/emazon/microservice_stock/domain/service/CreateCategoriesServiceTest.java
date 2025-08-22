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
    @Mock
    private CategoryRepository categoryRepository;
    // crea una instancia real y le inyecta el mock falso
    @InjectMocks
    private CreateCategoriesService createCategoriesService;

    @Test
    void createCategory() {
        String name ="test Category";
        String description = "description for test";
        ArgumentCaptor<Categories> categoriesArgumentCaptor = ArgumentCaptor.forClass(Categories.class);
        createCategoriesService.createCategory(name,description);
        verify(categoryRepository,times(1)).saveCategoryDb(categoriesArgumentCaptor.capture());
        Categories captureCategory = categoriesArgumentCaptor.getValue();
        assertEquals(name,captureCategory.getName());
        assertEquals(description,captureCategory.getDescription());

    }

    @Test
    void findAllCategories() {
        int page = 0;
        int size = 10;
        String sortBy = "name";
        String address ="asc";

        Pageable pageable = PageRequest.of(page,size);
        List<Categories>  categoriesList = Collections.singletonList(new Categories("test category","description"));
        Page<Categories> expectedPage = new PageImpl<>(categoriesList,pageable,1);

        when(categoryRepository.findAllCategories(page,size,sortBy,address)).thenReturn(expectedPage);
        Page<Categories> result = createCategoriesService.findAllCategories(page,size,sortBy,address);
        assertNotNull(result);
        assertEquals(1,result.getTotalElements());
        assertEquals("test category",result.getContent().get(0).getName());


    }
}