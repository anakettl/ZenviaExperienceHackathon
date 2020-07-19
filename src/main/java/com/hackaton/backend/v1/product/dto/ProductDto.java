package com.hackaton.backend.v1.product.dto;

import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.product.model.Product;

import java.time.LocalDateTime;

public class ProductDto {

    private String name;
    private String code;
    private String description;
    private Double price;
    private Department department;

    public Product convertToProduct() {
        return new Product(null, this.name, this.code, this.description, this.price, department, LocalDateTime.now());

}
