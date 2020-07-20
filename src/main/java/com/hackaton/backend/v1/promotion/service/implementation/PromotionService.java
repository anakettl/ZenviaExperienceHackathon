package com.hackaton.backend.v1.promotion.service.implementation;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.promotion.dto.PromotionDto;
import com.hackaton.backend.v1.promotion.model.Promotion;
import com.hackaton.backend.v1.promotion.repository.PromotionRepository;
import com.hackaton.backend.v1.promotion.service.interfaces.IPromotionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.hackaton.backend.v1.core.validation.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.hackaton.backend.v1.core.validation.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class PromotionService implements IPromotionService {
    
    private final PromotionRepository promotionRepository;

    @Override
    public ResourceCreated save(PromotionDto promotionDto) {
        return new ResourceCreated(promotionRepository.save(promotionDto.convertToPromotion()).getId());
    }

    @Override
    public Promotion findById(Long id) {
        return promotionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Promotion> findAll(Sort sort) {
        return promotionRepository.findAll(sort);
    }
}
