package com.hackaton.backend.v1.serviceOffered.dto;

import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.serviceOffered.model.ServiceOffered;
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
public class ServiceOfferedDto implements Serializable {

    private String name;
    private String code;
    private Company company;

    public ServiceOffered convertToServiceOffered() {
        return new ServiceOffered(null, this.name, this.code, company, LocalDateTime.now());
    }
}
