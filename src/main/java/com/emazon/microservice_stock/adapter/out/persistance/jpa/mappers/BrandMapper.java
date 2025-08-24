package com.emazon.microservice_stock.adapter.out.persistance.jpa.mappers;

import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.BrandEntity;
import com.emazon.microservice_stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandEntity brandToBrandEntity(Brand brand);
    @Mapping(target = "id",ignore = true)
    List<Brand> listBrandEntityToListBrands(List<BrandEntity> brandList);
}
