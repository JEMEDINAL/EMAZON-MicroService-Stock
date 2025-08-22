package com.emazon.microservice_stock.domain.exception.category;

import com.emazon.microservice_stock.domain.constant.category.CategoryErrorMessage;

public class CategoryNameMaxSizeExceeded extends RuntimeException{
    public CategoryNameMaxSizeExceeded(){
        super(CategoryErrorMessage.CATEGORY_NAME_MAX_SIZE.getMessage());
    }
}
