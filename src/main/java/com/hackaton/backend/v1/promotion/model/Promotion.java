package com.hackaton.backend.v1.promotion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.product.model.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

public class Promotion {
    public Promotion(Long id) { this.id = id; }

    @Id
    @Column(name = "UID_PROMOTION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROMOTION")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "BEGIN_DATE", nullable = false)
    private LocalDateTime beginDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "DESCRIPTION", nullable = false, length = 400)
    private String description;

    @Column(name = "DISCOUNT", nullable = false, columnDefinition = "INTEGER")
    private Integer discount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "FK_COMPANY_UID")
    private Company company;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }
}
