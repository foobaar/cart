package com.foobaar.cart.dao;

import java.math.BigDecimal;

public class Item {
    private final String id;
    private final String name;
    private final String description;
    private final BigDecimal unitPrice;
    private final String subCategory;

    public Item(final String id, final String name,
                final String description, final BigDecimal unitPrice,
                final String subCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.subCategory = subCategory;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getSubCategory() {
        return subCategory;
    }
}
