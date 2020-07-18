package com.hackaton.backend.v1.company.repository;

import com.hackaton.backend.v1.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCnpj(String cnpj);
}