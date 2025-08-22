package com.emazon.microservice_stock.domain.port.out;

import com.emazon.microservice_stock.domain.model.Categories;
import org.springframework.data.domain.Page;

public interface CategoryRepository {

    void saveCategoryDb(Categories categories);
    Page<Categories> findAllCategories(int page, int size, String sortBy, String address);
}
