package com.hackaton.backend.v1.department.dto;

import com.hackaton.backend.v1.department.model.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto implements Serializable {

    private String name;

    public Department convertToDepartment() {
        return new Department(null, this.name, LocalDateTime.now());
    }
}

