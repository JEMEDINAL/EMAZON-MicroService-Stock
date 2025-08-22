package com.emazon.microservice_stock.domain.exception.category;

import com.emazon.microservice_stock.domain.constant.category.CategoryErrorMessage;

public class CategoryNameExists extends RuntimeException{
    public CategoryNameExists(){
        super(CategoryErrorMessage.CATEGORY_NAME_EXISTS.getMessage());
    }
}
