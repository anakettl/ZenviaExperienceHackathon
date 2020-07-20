package com.hackaton.backend.v1.promotion.repository;

import com.hackaton.backend.v1.promotion.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long>{
}
