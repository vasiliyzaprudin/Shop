package com.mining.entity;

import java.util.List;

public class Order {
    private Long id;
    private String customerName;
    private List<String> products;
    private String status;

    public Order(Long id, String customerName, List<String> products, String status) {
        this.id = id;
        this.customerName = customerName;
        this.products = products;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public List<String> getProducts() { return products; }
    public String getStatus() { return status; }

    public void setStatus(String status) {this.status = status;}
}