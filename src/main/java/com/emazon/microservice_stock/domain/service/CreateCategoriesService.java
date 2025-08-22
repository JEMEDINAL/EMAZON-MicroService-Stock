package com.emazon.microservice_stock.domain.service;

import com.emazon.microservice_stock.domain.model.Categories;
import com.emazon.microservice_stock.domain.port.in.CreateCategoriesUseCase;
import com.emazon.microservice_stock.domain.port.out.CategoryRepository;
import org.springframework.data.domain.Page;

public class CreateCategoriesService implements CreateCategoriesUseCase {
    private final CategoryRepository categoryRepository;

    public CreateCategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(String name,String description) {

        categoryRepository.saveCategoryDb(new Categories(name, description));
    }

    @Override
    public Page<Categories> findAllCategories(int page, int size, String sortBy, String address) {
        return categoryRepository.findAllCategories(page, size, sortBy, address);
    }
}
