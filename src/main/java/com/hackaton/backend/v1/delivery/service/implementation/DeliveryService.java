package com.hackaton.backend.v1.delivery.service.implementation;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.delivery.dto.DeliveryDto;
import com.hackaton.backend.v1.delivery.model.Delivery;
import com.hackaton.backend.v1.delivery.repository.DeliveryRepository;
import com.hackaton.backend.v1.delivery.service.interfaces.IDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.hackaton.backend.v1.core.validation.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.hackaton.backend.v1.core.validation.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class DeliveryService implements IDeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    public ResourceCreated save(DeliveryDto deliveryDto) {
        return new ResourceCreated(deliveryRepository.save(deliveryDto.convertToDelivery()).getId());
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Delivery> findAll(Sort sort) {
        return deliveryRepository.findAll(sort);
    }
}
