package com.hackaton.backend.v1.department.model;

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
@SequenceGenerator(name = "SEQ_DEPARTMENT", sequenceName = "SEQUENCE_DEPARTMENT", allocationSize = 1)
public class Department implements Serializable {

    public Department(Long id) { this.id = id; }

    @Id
    @Column(name = "UID_DEPARTMENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DEPARTMENT")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "FK_COMPANY_UID")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "department")
    private Set<Product> products;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
   }
}
