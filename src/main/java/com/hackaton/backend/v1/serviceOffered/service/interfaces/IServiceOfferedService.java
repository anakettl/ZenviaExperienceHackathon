package com.hackaton.backend.v1.serviceOffered.service.interfaces;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.serviceOffered.dto.ServiceOfferedDto;
import com.hackaton.backend.v1.serviceOffered.model.ServiceOffered;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IServiceOfferedService {
    ResourceCreated save(ServiceOfferedDto serviceOfferedDto);

    ServiceOffered findById(Long id);

    List<ServiceOffered> findAll(Sort sort);
}
