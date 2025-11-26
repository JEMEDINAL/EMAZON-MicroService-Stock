package com.emazon.microservice_stock.domain.model;

import com.emazon.microservice_stock.domain.constant.category.CategoryBusinessRules;
import com.emazon.microservice_stock.domain.exception.category.CategoryDescriptionMaxSizeExceeded;
import com.emazon.microservice_stock.domain.exception.category.CategoryNameMaxSizeExceeded;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriesTest {
    @Test
    void caseWhenDataCorrect() {
        Categories categories = new Categories("Deportivos","Todas la marcas deportivas");

        assertEquals("Deportivos",categories.getName());
        assertEquals("Todas la marcas deportivas",categories.getDescription());

    }

    @Test
    void caseWhenNameExceedsCharacterLimit() {
        String longName = "A".repeat(CategoryBusinessRules.MAX_CHARACTER_NAME+1);
        assertThrows(
                CategoryNameMaxSizeExceeded.class,
                () -> new Categories(longName,"So gooood pa good")
        );
    }

    @Test
    void caseDescriptionMaxSizeExceeded() {
        String longDescription = "A".repeat(CategoryBusinessRules.MAX_CHARACTER_DESCRIPTION+1);
        assertThrows(CategoryDescriptionMaxSizeExceeded.class,
                ()-> new Categories("Nice",longDescription)
                );

    }
}