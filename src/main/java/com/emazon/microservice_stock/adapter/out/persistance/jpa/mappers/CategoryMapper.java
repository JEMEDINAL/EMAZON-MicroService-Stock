package com.emazon.microservice_stock.adapter.out.persistance.jpa.mappers;

import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.CategoriesEntity;
import com.emazon.microservice_stock.domain.model.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


import java.util.List;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoriesEntity categoryToCategoriesEntity(Categories categories);
    @Mapping(target = "id",ignore = true)
    List<Categories> listCategoriesEntityToListCategories(List<CategoriesEntity> categoriesEntityList);
}
