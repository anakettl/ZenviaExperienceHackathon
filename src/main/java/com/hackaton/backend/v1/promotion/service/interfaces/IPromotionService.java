package com.hackaton.backend.v1.promotion.service.interfaces;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.promotion.dto.PromotionDto;
import com.hackaton.backend.v1.promotion.model.Promotion;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IPromotionService {
    ResourceCreated save(PromotionDto promotionDto);

    Promotion findById(Long id);

    List<Promotion> findAll(Sort sort);
}

