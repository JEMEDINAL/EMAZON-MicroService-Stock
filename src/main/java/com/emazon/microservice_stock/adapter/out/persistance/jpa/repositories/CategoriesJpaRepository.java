package com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories;

import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesJpaRepository extends JpaRepository<CategoriesEntity,Long> {
    Optional<CategoriesEntity> findByName(String name);
}
