package com.hackaton.backend.v1.promotion.model;

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
@SequenceGenerator(name = "SEQ_PROMOTION", sequenceName = "SEQUENCE_PROMOTION", allocationSize = 1)
public class Promotion implements Serializable {
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
