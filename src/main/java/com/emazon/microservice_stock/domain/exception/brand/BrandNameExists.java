package com.emazon.microservice_stock.domain.exception.brand;

import com.emazon.microservice_stock.domain.constant.brand.BrandErrorMessage;

public class BrandNameExists extends RuntimeException{
    public BrandNameExists() {
        super(BrandErrorMessage.BRAND_NAME_EXISTS.getMessage());
    }
}
