package com.emazon.microservice_stock.domain.exception.category;

import com.emazon.microservice_stock.domain.constant.category.CategoryErrorMessage;

public class CategoryDescriptionMaxSizeExceeded extends RuntimeException{
    public CategoryDescriptionMaxSizeExceeded(){
        super(CategoryErrorMessage.CATEGORY_DESCRIPTION_MAX_SIZE.getMessage());
    }
}
