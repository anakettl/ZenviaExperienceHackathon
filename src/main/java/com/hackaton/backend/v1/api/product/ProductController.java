package com.hackaton.backend.v1.api.product;

import com.hackaton.backend.v1.core.model.ResourceCreated;
import com.hackaton.backend.v1.department.dto.DepartmentDto;
import com.hackaton.backend.v1.department.model.Department;
import com.hackaton.backend.v1.department.service.interfaces.IDepartmentService;
import com.hackaton.backend.v1.product.dto.ProductDto;
import com.hackaton.backend.v1.product.model.Product;
import com.hackaton.backend.v1.product.service.interfaces.IProductService;
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
@RequestMapping("/api/v1/companies/{id}/departments/{id}/products")
public class ProductController implements Serializable {

    private final IProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Product> list = productService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }
}
