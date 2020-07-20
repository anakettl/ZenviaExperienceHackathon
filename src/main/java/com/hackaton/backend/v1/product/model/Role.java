package com.hackaton.backend.v1.product.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name = "SEQ_ROLE", sequenceName = "SEQUENCE_ROLE", allocationSize = 1)
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "UID_ROLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROLE")
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
