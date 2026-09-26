package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;
import com.ecommerce.product_service.entity.Product;
import com.ecommerce.product_service.exception.ProductNotFoundException;
import com.ecommerce.product_service.mapper.ProductMapper;
import com.ecommerce.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    @Override
    public ProductResponse create(ProductRequest productRequest) {
        Product product=productMapper.toProduct(productRequest);
        product.setActive(true);
        Product savedProduct=productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findByActiveTrue().stream().map(productMapper::toResponse).toList();
    }
    public Product getProduct(Long id){
        return productRepository.findByActiveTrueAndId(id).orElseThrow(
                ()->new ProductNotFoundException("Product not found with id: " + id)
        );
    }
    @Override
    public ProductResponse findById(Long id) {
        Product product=getProduct(id);
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse updateById(Long id, ProductRequest productRequest) {
        Product product=getProduct(id);
        productMapper.update(productRequest,product);
        Product updatedProduct=productRepository.save(product);
        return productMapper.toResponse(updatedProduct);
    }

    @Override
    public void deleteById(Long id) {
        Product product=getProduct(id);
        product.setActive(false);
        productRepository.save(product);
    }
}
