package com.emazon.microservice_stock.domain.port.in;


import com.emazon.microservice_stock.domain.model.Categories;
import org.springframework.data.domain.Page;


public interface CreateCategoriesUseCase {
    void createCategory(String name,String description);
    Page<Categories> findAllCategories(int page, int size, String sortBy, String address);

}
