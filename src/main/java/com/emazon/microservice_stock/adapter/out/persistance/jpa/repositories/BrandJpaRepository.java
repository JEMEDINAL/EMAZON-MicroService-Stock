package com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories;

import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandJpaRepository extends JpaRepository<BrandEntity,Long> {
    Optional<BrandEntity> findByName(String name);
}
