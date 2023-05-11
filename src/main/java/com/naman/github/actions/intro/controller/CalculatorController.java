package com.naman.github.actions.intro.controller;

import com.naman.github.actions.intro.domain.ApiResponse;
import com.naman.github.actions.intro.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/calculator")
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("{num1}/{num2}")
    public ResponseEntity<ApiResponse> addTwoNumbers(
            @PathVariable("num1") int num1,
            @PathVariable("num2") int num2
    ) {

        // adding two numbers
        var result = calculatorService.addTwoNumbers(num1, num2);

        return ResponseEntity.ok(ApiResponse.builder()
                .timestamp(LocalDateTime.now())
                .result(result)
                .build());
    }

}
