package com.emazon.microservice_stock.adapter.out.persistance.jpa.repositories;

import com.emazon.microservice_stock.adapter.out.persistance.jpa.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaRepository extends JpaRepository<ArticleEntity,Long> {
}
