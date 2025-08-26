package com.emazon.microservice_stock.adapter.in.web.dto;

import com.emazon.microservice_stock.domain.constant.article.ArticleBusinessRules;

import jakarta.validation.constraints.Pattern;
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
public class ArticleRequest {
    @Pattern(regexp = "^(?!\\d+$).+", message = ArticleBusinessRules.NOT_ONLY_NUMBERS)
    private String name;
    private int stock;
    private BigDecimal price;
    private Set<Long> categories;
    private Long brand;
}
