package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest productRequest);
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
    ProductResponse updateById(Long id, ProductRequest productRequest);
    void deleteById(Long id);
}
