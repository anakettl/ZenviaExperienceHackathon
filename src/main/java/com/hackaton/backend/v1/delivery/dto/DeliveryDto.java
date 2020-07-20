package com.hackaton.backend.v1.delivery.dto;

import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.delivery.model.Delivery;
import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto implements Serializable {
    private String region;
    private Double price;
    private Company company;

    public Delivery convertToDelivery() {
        return new Delivery(null, this.region, this.price, company, LocalDateTime.now());
    }
}
