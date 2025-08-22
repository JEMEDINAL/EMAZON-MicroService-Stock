package com.emazon.microservice_stock.domain.exception.brand;

import com.emazon.microservice_stock.domain.constant.brand.BrandErrorMessage;

public class BrandDescriptionMaxSizeExceeded extends RuntimeException{
    public BrandDescriptionMaxSizeExceeded() {
        super(BrandErrorMessage.BRAND_DESCRIPTION_MAX_SIZE.getMessage());
    }
}
