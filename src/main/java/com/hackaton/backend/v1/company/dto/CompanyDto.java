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
    private String cnpj;

    public CompanyDto(String validCnpj) {
        this.cnpj = validCnpj;
    }

    public Company convertToCompany() {
        return new Company(null, this.name, this.cnpj, LocalDateTime.now());
    }
}
