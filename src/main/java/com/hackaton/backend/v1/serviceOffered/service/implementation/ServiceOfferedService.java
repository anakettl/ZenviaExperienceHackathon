package com.hackaton.backend.v1.serviceOffered.service.implementation;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.serviceOffered.dto.ServiceOfferedDto;
import com.hackaton.backend.v1.serviceOffered.model.ServiceOffered;
import com.hackaton.backend.v1.serviceOffered.repository.ServiceOfferedRepository;
import com.hackaton.backend.v1.serviceOffered.service.interfaces.IServiceOfferedService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.hackaton.backend.v1.core.validation.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.hackaton.backend.v1.core.validation.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class ServiceOfferedService implements IServiceOfferedService {

    private final ServiceOfferedRepository serviceOfferedRepository;

    @Override
    public ResourceCreated save(ServiceOfferedDto serviceOfferedDto) {
        return new ResourceCreated(serviceOfferedRepository.save(serviceOfferedDto.convertToServiceOffered()).getId());
    }

    @Override
    public ServiceOffered findById(Long id) {
        return serviceOfferedRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<ServiceOffered> findAll(Sort sort) {
        return serviceOfferedRepository.findAll(sort);
    }
}