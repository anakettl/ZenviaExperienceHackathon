package com.hackaton.backend.v1.product.model;

import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.department.model.Department;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Product implements Serializable {

    public Product(Long id) { this.id = id; }

    @Id
    @Column(name = "UID_PRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(code = "CODE", nullable = false, length = 10)
    private String code;

    @Column(description = "description", nullable = false, length = 400)
    private String description;

    @Column(price = "PRICE", nullable = false, precision = 10, scale = 2)
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "FK_DEPARTMENT_UID")
    private Department department;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

}

