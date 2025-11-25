package com.emazon.microservice_stock.domain.port.out;

import com.emazon.microservice_stock.adapter.in.web.dto.CategoryDto;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.CategoriesEntity;
import com.emazon.microservice_stock.domain.model.Categories;
import org.springframework.data.domain.Page;

public interface CategoryRepository {

    void saveCategoryDb(Categories categories);
    Page<CategoryDto> findAllCategories(int page, int size, String sortBy, String address);
}
