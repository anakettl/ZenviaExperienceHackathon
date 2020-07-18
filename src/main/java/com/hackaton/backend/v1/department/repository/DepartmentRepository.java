package com.hackaton.backend.v1.department.repository;

import com.hackaton.backend.v1.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
