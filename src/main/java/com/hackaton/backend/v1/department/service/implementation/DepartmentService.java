package com.hackaton.backend.v1.department.service.implementation;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.department.dto.DepartmentDto;
import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.department.repository.DepartmentRepository;
import com.hackaton.backend.v1.department.service.interfaces.IDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.hackaton.backend.v1.core.validation.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.hackaton.backend.v1.core.validation.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public ResourceCreated save(DepartmentDto departmentDto) {
        return new ResourceCreated(departmentRepository.save(departmentDto.convertToDepartment()).getId());
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Department> findAll(Sort sort) {
        return departmentRepository.findAll(sort);
    }
}