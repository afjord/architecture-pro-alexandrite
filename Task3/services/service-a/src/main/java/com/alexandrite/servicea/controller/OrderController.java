package com.alexandrite.servicea.controller;

import com.alexandrite.servicea.client.CalculationClient;
import com.alexandrite.servicea.model.CalculationResponse;
import com.alexandrite.servicea.model.OrderSummaryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final CalculationClient calculationClient;

    public OrderController(CalculationClient calculationClient) {
        this.calculationClient = calculationClient;
    }

    @GetMapping("/summary")
    public OrderSummaryResponse getOrderSummary(
            @RequestParam(defaultValue = "Alex") String customer,
            @RequestParam(defaultValue = "150") int firstItemPrice,
            @RequestParam(defaultValue = "200") int secondItemPrice
    ) {
        CalculationResponse calculation = calculationClient.calculateTotal(firstItemPrice, secondItemPrice);

        return new OrderSummaryResponse(
                customer,
                calculation.first(),
                calculation.second(),
                calculation.total(),
                "created"
        );
    }
}
