package com.hackaton.backend.v1.api.department;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.department.dto.DepartmentDto;
import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.department.service.interfaces.IDepartmentService;
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
@RequestMapping("/api/v1/departments")
public class DepartmentController implements Serializable {

    private final IDepartmentService departmentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Department>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Department> list = departmentService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.save(departmentDto), HttpStatus.CREATED);
    }
}
