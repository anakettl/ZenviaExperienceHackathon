package com.hackaton.backend.v1.product.service.implementation;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.product.dto.ProductDto;
import com.hackaton.backend.v1.product.model.Product;
import com.hackaton.backend.v1.product.repository.ProductRepository;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.hackaton.backend.v1.core.validation.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.hackaton.backend.v1.core.validation.MessageValidationProperties.getMessage;

public class ProductService {

    private final ProductRepository productRepository;

    @Override
    public ResourceCreated save(ProductDto productDto) {
        return new ResourceCreated(productRepository.save(productDto.convertToProduct()).getId());
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }
}
