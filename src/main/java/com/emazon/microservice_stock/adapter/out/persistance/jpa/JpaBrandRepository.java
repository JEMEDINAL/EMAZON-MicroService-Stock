package com.emazon.microservice_stock.adapter.out.persistance.jpa;

import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.BrandEntity;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.mappers.BrandMapper;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories.BrandJpaRepository;
import com.emazon.microservice_stock.domain.exception.brand.BrandNameExists;
import com.emazon.microservice_stock.domain.model.Brand;
import com.emazon.microservice_stock.domain.port.out.BrandRepository;
;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class JpaBrandRepository implements BrandRepository {
    private final BrandJpaRepository brandJpaRepository;
    private final BrandMapper brandMapper;

    public JpaBrandRepository(BrandJpaRepository brandJpaRepository, BrandMapper brandMapper) {
        this.brandJpaRepository = brandJpaRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public void createBrand(Brand brand) {
        if(brandJpaRepository.findByName(brand.getName()).isPresent()){
            throw new BrandNameExists();
        }
        brandJpaRepository.save(brandMapper.brandToBrandEntity(brand));
    }

    @Override
    public Page<Brand> findAllBrand(int page, int size, String sortBy, String address) {
        Sort sort = null;
        if (address.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<BrandEntity> entityPage = brandJpaRepository.findAll(pageable);
        List<Brand> brandList = brandMapper.listBrandEntityToListBrands(entityPage.getContent());

        return new PageImpl<>(brandList,pageable,entityPage.getTotalElements());

    }
}
