package com.hackaton.backend.v1.company.service.implementation;

import com.hackaton.backend.v1.company.dto.CompanyDto;
import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.company.repository.CompanyRepository;
import com.hackaton.backend.v1.company.service.interfaces.ICompanyService;
import com.hackaton.backend.v1.core.model.ResourceCreated;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.hackaton.backend.v1.core.validation.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.hackaton.backend.v1.core.validation.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public ResourceCreated save(CompanyDto companyDto) {
        return new ResourceCreated(companyRepository.save(companyDto.convertToCompany()).getId());
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Company> findAll(Sort sort) {
        return companyRepository.findAll(sort);
    }
}
