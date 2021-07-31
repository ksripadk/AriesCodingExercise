package com.aries.prototype.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductList {
    private List<Product> productsList;

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
