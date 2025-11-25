package com.emazon.microservice_stock.adapter.out.persistance.jpa;

import com.emazon.microservice_stock.adapter.in.web.dto.BrandResponse;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.BrandEntity;
import com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories.BrandJpaRepository;
import com.emazon.microservice_stock.domain.exception.brand.BrandNameExists;
import com.emazon.microservice_stock.domain.model.Brand;
import com.emazon.microservice_stock.domain.port.out.BrandRepository;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBrandRepository implements BrandRepository {
    private final BrandJpaRepository brandJpaRepository;

    public JpaBrandRepository(BrandJpaRepository brandJpaRepository) {
        this.brandJpaRepository = brandJpaRepository;
    }

    @Override
    public void createBrand(Brand brand) {
        if(brandJpaRepository.findByName(brand.getName()).isPresent()){
            throw new BrandNameExists();
        }
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName(brand.getName());
        brandEntity.setDescription(brand.getDescription());
        brandJpaRepository.save(brandEntity);
    }

    @Override
    public Page<BrandResponse> findAllBrand(int page, int size, String sortBy, String address) {
        Sort sort = null;
        if (address.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<BrandEntity> entityPage = brandJpaRepository.findAll(pageable);
        Page<BrandResponse> brandResponses = entityPage.map(brand ->{
            BrandResponse brandResponse = new BrandResponse();
            brandResponse.setId(brand.getId());
            brandResponse.setName(brand.getName());
            brandResponse.setDescription(brand.getDescription());
            return brandResponse;
        });
        return new PageImpl<>(brandResponses.getContent(),pageable,entityPage.getTotalElements());
    }
}
