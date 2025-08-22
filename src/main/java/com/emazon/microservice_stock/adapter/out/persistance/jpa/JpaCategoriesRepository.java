package com.emazon.microservice_stock.adapter.out.persistance.jpa;

import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.CategoriesEntity;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.mappers.CategoryMapper;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories.CategoriesJpaRepository;
import com.emazon.microservice_stock.domain.exception.category.CategoryNameExists;
import com.emazon.microservice_stock.domain.model.Categories;
import com.emazon.microservice_stock.domain.port.out.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaCategoriesRepository implements CategoryRepository {
    private final CategoriesJpaRepository categoriesJpaRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public void saveCategoryDb(Categories categories) {
        if(categoriesJpaRepository.findByName(categories.getName()).isPresent()){
            throw new CategoryNameExists();
        }
        CategoriesEntity categoriesEntity = categoryMapper.categoryToCategoriesEntity(categories);

        categoriesJpaRepository.save(categoriesEntity);
    }

    @Override
    public Page<Categories> findAllCategories(int page, int size, String sortBy, String address) {
        Sort sort = null;
        if (address.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<CategoriesEntity> entityPage = categoriesJpaRepository.findAll(pageable);
        List<Categories> categoriesList = categoryMapper.listCategoriesEntityToListCategories(entityPage.getContent());

        return new PageImpl<>(categoriesList,pageable,entityPage.getTotalElements());
    }
}
