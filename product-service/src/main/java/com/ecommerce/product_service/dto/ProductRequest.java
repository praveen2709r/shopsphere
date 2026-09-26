package com.ecommerce.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "Product name is required")
        String name,
        String description,
        @Positive(message = "Price must be greater than zero")
        @NotNull(message = "Price is required")
        BigDecimal price,
        @NotNull(message = "stock is required")
        @Positive(message = "stock must be greater than zero")
        Integer stock
) {
}
