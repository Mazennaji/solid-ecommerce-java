package org.example.model;

import java.util.List;

public class Order {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}