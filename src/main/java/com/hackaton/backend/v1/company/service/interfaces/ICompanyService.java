package com.hackaton.backend.v1.company.service.interfaces;

import com.hackaton.backend.v1.company.dto.CompanyDto;
import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.core.model.ResourceCreated;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ICompanyService {

    ResourceCreated save(CompanyDto companyDto);

    Company findById(Long id);

    List<Company> findAll(Sort sort);

}
