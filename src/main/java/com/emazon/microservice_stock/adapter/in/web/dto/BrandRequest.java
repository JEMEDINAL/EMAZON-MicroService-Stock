package com.emazon.microservice_stock.adapter.in.web.dto;

import com.emazon.microservice_stock.domain.constant.brand.BrandBusinessRules;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandRequest {
    @Pattern(regexp = "^(?!\\d+$).+", message = BrandBusinessRules.NOT_ONLY_NUMBERS)
    private String name;
    @Pattern(regexp = "[a-zA-Z\\s]+", message = BrandBusinessRules.NOT_ONLY_NUMBERS)
    private String description;
}
