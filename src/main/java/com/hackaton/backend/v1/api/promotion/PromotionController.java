package com.hackaton.backend.v1.api.promotion;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.promotion.dto.PromotionDto;
import com.hackaton.backend.v1.promotion.model.Promotion;
import com.hackaton.backend.v1.promotion.service.interfaces.IPromotionService;
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
@RequestMapping("/api/v1/companies/{id}/promotions")
public class PromotionController implements Serializable {
    private final IPromotionService promotionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Promotion>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Promotion> list = promotionService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Promotion> findById(@PathVariable Long id) {
        return new ResponseEntity<>(promotionService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody PromotionDto promotionDto) {
        return new ResponseEntity<>(promotionService.save(promotionDto), HttpStatus.CREATED);
    }

}
