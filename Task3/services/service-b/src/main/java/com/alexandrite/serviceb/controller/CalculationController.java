package com.alexandrite.serviceb.controller;

import com.alexandrite.serviceb.model.CalculationResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculations")
public class CalculationController {

    @GetMapping("/total")
    public CalculationResult getTotal(
            @RequestParam(defaultValue = "0") int first,
            @RequestParam(defaultValue = "0") int second
    ) {
        return new CalculationResult(first, second, first + second, "service-b");
    }
}
