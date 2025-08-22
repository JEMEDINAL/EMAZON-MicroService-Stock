package com.emazon.microservice_stock.domain.model;

import com.emazon.microservice_stock.domain.constant.brand.BrandBusinessRules;
import com.emazon.microservice_stock.domain.exception.brand.BrandDescriptionMaxSizeExceeded;
import com.emazon.microservice_stock.domain.exception.brand.BrandNameMaxSizeExceeded;

public class Brand {
    private String name;
    private String description;

    public Brand(String name, String description) {
        if(name.length() > BrandBusinessRules.MAX_CHARACTER_NAME){
            throw new BrandNameMaxSizeExceeded();
        }
        if(description.length() > BrandBusinessRules.MAX_CHARACTER_DESCRIPTION){
            throw new BrandDescriptionMaxSizeExceeded();
        }
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
