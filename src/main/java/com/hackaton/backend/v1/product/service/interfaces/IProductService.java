package com.hackaton.backend.v1.product.service.interfaces;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.product.dto.ProductDto;
import com.hackaton.backend.v1.product.model.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductService {
    ResourceCreated save(ProductDto productDto);

    Product findById(Long id);

    List<Product> findAll(Sort sort);
}
