package com.alexandrite.servicea.client;

import com.alexandrite.servicea.model.CalculationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CalculationClient {

    private final RestClient restClient;
    private final String calculationServiceBaseUrl;

    public CalculationClient(
            RestClient restClient,
            @Value("${services.calculation.base-url}") String calculationServiceBaseUrl
    ) {
        this.restClient = restClient;
        this.calculationServiceBaseUrl = calculationServiceBaseUrl;
    }

    public CalculationResponse calculateTotal(int firstItemPrice, int secondItemPrice) {
        return restClient.get()
                .uri(
                        calculationServiceBaseUrl + "/api/calculations/total?first={first}&second={second}",
                        firstItemPrice,
                        secondItemPrice
                )
                .retrieve()
                .body(CalculationResponse.class);
    }
}
