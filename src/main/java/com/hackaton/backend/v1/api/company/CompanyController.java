package com.hackaton.backend.v1.api.company;

import com.hackaton.backend.v1.company.dto.CompanyDto;
import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.company.service.interfaces.ICompanyService;
import com.hackaton.backend.v1.core.model.ResourceCreated;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController implements Serializable {

    private final ICompanyService companyService;

    public CompanyController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Company> list = companyService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody CompanyDto companyDto) {
        return new ResponseEntity<>(companyService.save(companyDto), HttpStatus.CREATED);
    }
}
