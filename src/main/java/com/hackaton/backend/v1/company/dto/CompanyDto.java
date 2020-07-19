package com.hackaton.backend.v1.company.dto;

import com.hackaton.backend.v1.company.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto implements Serializable {

    private String name;
    private String cpf;

    public CompanyDto(String validCpf) {
        this.cpf = validCpf;
    }

    public Company convertToAssociated() {
        return new Company(null, this.name, this.cpf, LocalDateTime.now());
    }
}
