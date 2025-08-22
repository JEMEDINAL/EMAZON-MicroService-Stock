package com.emazon.microservice_stock.domain.model;

import com.emazon.microservice_stock.domain.constant.category.CategoryBusinessRules;
import com.emazon.microservice_stock.domain.exception.category.CategoryDescriptionMaxSizeExceeded;
import com.emazon.microservice_stock.domain.exception.category.CategoryNameMaxSizeExceeded;

public class Categories {
    private String name;
    private String description;

    public Categories(String name, String description) {
        if(name.length() > CategoryBusinessRules.MAX_CHARACTER_NAME){
            throw new CategoryNameMaxSizeExceeded();
        }

        if(description.isEmpty() || description.length() > CategoryBusinessRules.MAX_CHARACTER_DESCRIPTION){
            throw  new CategoryDescriptionMaxSizeExceeded();
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
