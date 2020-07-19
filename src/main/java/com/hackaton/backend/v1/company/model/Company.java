package com.hackaton.backend.v1.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.serviceOffered.model.ServiceOffered;
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
@SequenceGenerator(name = "SEQ_COMPANY", sequenceName = "SEQUENCE_COMPANY", allocationSize = 1)
public class Company implements Serializable {

    public Company(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "UID_COMPANY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMPANY")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "CNPJ", nullable = false, length = 11, unique = true)
    private String cnpj;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "company")
    private Set<Department> departments;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "company")
    private Set<ServiceOffered> servicesOffered;

    @Column(name = "CREATED_AT", nullable = false)
    protected LocalDateTime createdAt;
}
