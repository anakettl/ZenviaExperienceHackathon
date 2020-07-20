package com.hackaton.backend.v1.api.delivery;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.delivery.dto.DeliveryDto;
import com.hackaton.backend.v1.delivery.model.Delivery;
import com.hackaton.backend.v1.delivery.service.interfaces.IDeliveryService;
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
@RequestMapping("/api/v1/companies/{id}/deliveries")
public class DeliveryController implements Serializable {

    private final IDeliveryService deliveryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Delivery>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Delivery> list = deliveryService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Delivery> findById(@PathVariable Long id) {
        return new ResponseEntity<>(deliveryService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody DeliveryDto deliveryDto) {
        return new ResponseEntity<>(deliveryService.save(deliveryDto), HttpStatus.CREATED);
    }
}
