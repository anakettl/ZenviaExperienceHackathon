package com.hackaton.backend.v1.serviceOffered.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackaton.backend.v1.company.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name = "SEQ_SERV_OFFERED", sequenceName = "SEQUENCE_SERV_OFFERED", allocationSize = 1)
public class ServiceOffered implements Serializable {

    public ServiceOffered(Long id) { this.id = id; }

    @Id
    @Column(name = "UID_SERV_OFFERED")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SERV_OFFERED")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "CODE", nullable = false, length = 10)
    private String code;

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
