package com.emazon.microservice_stock.domain.model;

import com.emazon.microservice_stock.domain.constant.article.ArticleBusinessRules;
import com.emazon.microservice_stock.domain.exception.article.*;


import java.math.BigDecimal;
import java.util.Set;

public class Article {
    private String name;
    private int stock;
    private BigDecimal price;
    private Set<Long> categories;
    private Long brand;

    public Article(String name, int stock, BigDecimal price, Long brand, Set<Long> categories) {
        if(name.isEmpty()||name.length()> ArticleBusinessRules.MAX_VALUR_NAME){
            throw new ArticleMaxSizeName();
        }
        if(stock < ArticleBusinessRules.MIN_VALUE_STOCK){
            throw new ArticleStockMinValue();
        }
        if(price.intValue() < ArticleBusinessRules.MIN_VALUE_PRICE){
            throw new ArticleMinValuePrice();
        }
        if(categories.size()> ArticleBusinessRules.MAX_VALUE_CATEGORIES){
            throw new MaxRelatedCategories();
        }
        if(brand == null){
            throw new NoNullBrand();
        }
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.brand = brand;
        this.categories = categories;

    }

    public Article() {


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Long> getCategories() {
        return categories;
    }

    public void setCategories(Set<Long> categories) {
        this.categories = categories;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }
}

