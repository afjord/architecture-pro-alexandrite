package com.alexandrite.servicea.model;

public record OrderSummaryResponse(
        String customer,
        int firstItemPrice,
        int secondItemPrice,
        int totalPrice,
        String status
) {
}
