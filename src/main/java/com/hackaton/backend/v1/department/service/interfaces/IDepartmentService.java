package com.hackaton.backend.v1.department.service.interfaces;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.department.dto.DepartmentDto;
import com.hackaton.backend.v1.department.model.Department;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IDepartmentService {

    ResourceCreated save(DepartmentDto departmentDto);

    Department findById(Long id);

    List<Department> findAll(Sort sort);
}
