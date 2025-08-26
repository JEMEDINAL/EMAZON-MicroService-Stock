package com.emazon.microservice_stock.adapter.in.web.dto;

import com.emazon.microservice_stock.domain.constant.category.CategoryBusinessRules;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesRequest {
    @Pattern(regexp = "^(?!\\d+$).+", message = CategoryBusinessRules.NOT_ONLY_NUMBERS)
    private String name;
    @Pattern(regexp = "[a-zA-Z\\s]+", message = CategoryBusinessRules.NOT_ONLY_NUMBERS)
    private String description;
}
