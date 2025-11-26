package com.emazon.microservice_stock.domain.model;

import com.emazon.microservice_stock.domain.constant.brand.BrandBusinessRules;
import com.emazon.microservice_stock.domain.exception.brand.BrandDescriptionMaxSizeExceeded;
import com.emazon.microservice_stock.domain.exception.brand.BrandNameMaxSizeExceeded;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {

    @Test
    void caseWhenDataCorrect() {
        Brand brand = new Brand("Nike","Make to EEUU");

        assertEquals("Nike",brand.getName());
        assertEquals("Make to EEUU",brand.getDescription());
    }

    @Test
    void caseWhenNameExceedesCharacterLimit() {
        String longName = "A".repeat(BrandBusinessRules.MAX_CHARACTER_NAME+1);
        assertThrows(
                BrandNameMaxSizeExceeded.class,
                ()-> new Brand(longName,"Soo good pa")
        );
    }

    @Test
    void caseWhenDescriptionExceedesCharacterLimit() {
        String longDescription = "A".repeat(BrandBusinessRules.MAX_CHARACTER_DESCRIPTION+1);

        assertThrows(
                BrandDescriptionMaxSizeExceeded.class,
                () -> new Brand("nike",longDescription)

        );
    }
}