package com.emazon.microservice_stock.adapter.out.persistance.jpa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @ManyToMany(mappedBy = "categories")
    private Set<ArticleEntity> articles = new HashSet<>();
}
