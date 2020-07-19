package com.hackaton.backend.v1.promotion.dto;

import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.promotion.model.Promotion;

import java.time.LocalDateTime;

public class PromotionDto {

    private String name;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private String description;
    private Integer discount;
    private Company company;

    public Promotion convertToPromotion() {
        return new PromotionDto(null, this.name, this.beginDate, this.endDate, this.description, this.discount, company, LocalDateTime.now());
    }
}



