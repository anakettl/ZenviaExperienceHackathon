package com.hackaton.backend.v1.department.dto;

import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.product.model.Product;
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
public class DepartmentDto implements Serializable {

    private String name;
    private Company company;
    private Set<Product> products;

    public Department convertToDepartment() {
        return new Department(null, this.name, company, products, LocalDateTime.now());
    }
}

