package com.emazon.microservice_stock.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDtoResponse {
    private Long id;
    private String name;
    private int stock;
    private BigDecimal price;
    private Set<CategoryDto> categories;
    private BrandResponse brandResponse;
}
