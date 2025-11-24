package com.emazon.microservice_stock.adapter.out.persistance.jpa;

import com.emazon.microservice_stock.adapter.in.web.dto.CategoryDto;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.CategoriesEntity;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories.CategoriesJpaRepository;
import com.emazon.microservice_stock.domain.exception.category.CategoryNameExists;
import com.emazon.microservice_stock.domain.model.Categories;
import com.emazon.microservice_stock.domain.port.out.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaCategoriesRepository implements CategoryRepository {
    private final CategoriesJpaRepository categoriesJpaRepository;

    @Override
    public void saveCategoryDb(Categories categories) {
        if(categoriesJpaRepository.findByName(categories.getName()).isPresent()){
            throw new CategoryNameExists();
        }
        CategoriesEntity categoriesEntity = new CategoriesEntity();
        categoriesEntity.setName(categories.getName());
        categoriesEntity.setDescription(categories.getDescription());


        categoriesJpaRepository.save(categoriesEntity);
    }

    @Override
    public Page<CategoryDto> findAllCategories(int page, int size, String sortBy, String address) {
        Sort sort = null;
        if (address.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<CategoriesEntity> entityPage = categoriesJpaRepository.findAll(pageable);
        Page <CategoryDto> categoryDtos = entityPage.map(cate ->{
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(cate.getId());
            categoryDto.setName(cate.getName());
            categoryDto.setDescription(cate.getDescription());
            return categoryDto;
        });

        return new PageImpl<>(categoryDtos.getContent(),pageable,entityPage.getTotalElements());
    }
}
