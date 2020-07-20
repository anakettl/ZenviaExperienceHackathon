package com.hackaton.backend.v1.delivery.service.interfaces;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.delivery.dto.DeliveryDto;
import com.hackaton.backend.v1.delivery.model.Delivery;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IDeliveryService {
    ResourceCreated save(DeliveryDto deliveryDto);

    Delivery findById(Long id);

    List<Delivery> findAll(Sort sort);
}
