package com.hackaton.backend.v1.promotion.dto;

import com.hackaton.backend.v1.company.model.Company;
import com.hackaton.backend.v1.promotion.model.Promotion;
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
public class PromotionDto implements Serializable {

    private String name;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private String description;
    private Integer discount;
    private Company company;

    public Promotion convertToPromotion() {
        return new Promotion(null, this.name, this.beginDate, this.endDate, this.description, this.discount, company, LocalDateTime.now());
    }
}



