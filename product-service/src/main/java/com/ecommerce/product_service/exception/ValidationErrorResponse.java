package com.ecommerce.product_service.exception;

import java.util.Map;

public record ValidationErrorResponse(
        int status,
        String message,
        Map<String, String> errors
) {
}