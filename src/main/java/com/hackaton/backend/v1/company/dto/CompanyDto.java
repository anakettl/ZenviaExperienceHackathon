package com.hackaton.backend.v1.company.dto;

import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.serviceOffered.model.ServiceOffered;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto implements Serializable {

    private String name;
    private String cnpj;
    private Set<Department> departments;
    private Set<ServiceOffered> servicesOffered;

    public CompanyDto(String validCnpj) {
        this.cnpj = validCnpj;
    }

    public Company convertToCompany() {
        return new Company(null, this.name, this.cnpj, departments, servicesOffered, LocalDateTime.now());
    }
}
