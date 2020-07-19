package com.hackaton.backend.v1.api.serviceOffered;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.department.dto.DepartmentDto;
import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.department.service.interfaces.IDepartmentService;
import com.hackaton.backend.v1.serviceOffered.dto.ServiceOfferedDto;
import com.hackaton.backend.v1.serviceOffered.model.ServiceOffered;
import com.hackaton.backend.v1.serviceOffered.service.interfaces.IServiceOfferedService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/companies/{id}/services_offered")
public class ServiceOfferedController implements Serializable {

    private final IServiceOfferedService serviceOfferedService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceOffered>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<ServiceOffered> list = serviceOfferedService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceOffered> findById(@PathVariable Long id) {
        return new ResponseEntity<>(serviceOfferedService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody ServiceOfferedDto serviceOfferedDto) {
        return new ResponseEntity<>(serviceOfferedService.save(serviceOfferedDto), HttpStatus.CREATED);
    }
}