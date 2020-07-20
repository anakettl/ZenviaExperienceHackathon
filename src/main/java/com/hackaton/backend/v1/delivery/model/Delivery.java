package com.hackaton.backend.v1.delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Table
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name = "SEQ_DELIVERY", sequenceName = "SEQUENCE_DELIVERY", allocationSize = 1)
public class Delivery implements Serializable {

    public Delivery(Long id) { this.id = id; }

    @Id
    @Column(name = "UID_DELIVERY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DELIVERY")
    private Long id;

    @Column(name = "REGION", nullable = false, length = 200)
    private String region;

    @Column(name = "PRICE", nullable = false, columnDefinition = "NUMERIC(19,0)")
    private Double price;

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
