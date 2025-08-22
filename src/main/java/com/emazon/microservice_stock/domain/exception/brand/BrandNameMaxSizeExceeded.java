package com.emazon.microservice_stock.domain.exception.brand;

import com.emazon.microservice_stock.domain.constant.brand.BrandErrorMessage;

public class BrandNameMaxSizeExceeded extends RuntimeException{
    public BrandNameMaxSizeExceeded() {
        super(BrandErrorMessage.BRAND_NAME_MAX_SIZE.getMessage());
    }
}
