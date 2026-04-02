package com.alexandrite.servicea.model;

public record CalculationResponse(
        int first,
        int second,
        int total,
        String service
) {
}
