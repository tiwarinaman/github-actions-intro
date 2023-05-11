package com.naman.github.actions.intro.controller;

import com.naman.github.actions.intro.domain.ApiResponse;
import com.naman.github.actions.intro.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("CalculatorController Test Cases")
class CalculatorControllerTest {

    @Mock
    private CalculatorService calculatorService;

    @Test
    @DisplayName("Test adding two positive numbers")
    void addTwoPositiveNumbersTest() {
        // Arrange
        int num1 = 2;
        int num2 = 3;
        int expected = 5;
        when(calculatorService.addTwoNumbers(num1, num2)).thenReturn(expected);

        CalculatorController calculatorController = new CalculatorController(calculatorService);

        // Act
        ResponseEntity<ApiResponse> responseEntity = calculatorController.addTwoNumbers(num1, num2);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ApiResponse apiResponse = responseEntity.getBody();

        assert apiResponse != null;
        assertEquals(expected, apiResponse.result());
        assertEquals(LocalDateTime.now().getYear(), apiResponse.timestamp().getYear());
    }

    @Test
    @DisplayName("Test adding two negative numbers")
    void addTwoNegativeNumbersTest() {
        // Arrange
        int num1 = -2;
        int num2 = -3;
        int expected = -5;
        when(calculatorService.addTwoNumbers(num1, num2)).thenReturn(expected);

        CalculatorController calculatorController = new CalculatorController(calculatorService);

        // Act
        ResponseEntity<ApiResponse> responseEntity = calculatorController.addTwoNumbers(num1, num2);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ApiResponse apiResponse = responseEntity.getBody();

        assert apiResponse != null;
        assertEquals(expected, apiResponse.result());
        assertEquals(LocalDateTime.now().getYear(), apiResponse.timestamp().getYear());
    }

    @Test
    @DisplayName("Test adding zero to a number")
    void addZeroToNumberTest() {
        // Arrange
        int num1 = 2;
        int num2 = 0;
        int expected = 2;
        when(calculatorService.addTwoNumbers(num1, num2)).thenReturn(expected);

        CalculatorController calculatorController = new CalculatorController(calculatorService);

        // Act
        ResponseEntity<ApiResponse> responseEntity = calculatorController.addTwoNumbers(num1, num2);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ApiResponse apiResponse = responseEntity.getBody();

        assert apiResponse != null;
        assertEquals(expected, apiResponse.result());
        assertEquals(LocalDateTime.now().getYear(), apiResponse.timestamp().getYear());
    }

    @Test
    @DisplayName("Test adding two large numbers")
    void addTwoLargeNumbersTest() {
        // Arrange
        int num1 = 2147483646;
        int num2 = 2147483647;
        int expected = -2147483643;
        when(calculatorService.addTwoNumbers(num1, num2)).thenReturn(expected);

        CalculatorController calculatorController = new CalculatorController(calculatorService);

        // Act
        ResponseEntity<ApiResponse> responseEntity = calculatorController.addTwoNumbers(num1, num2);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ApiResponse apiResponse = responseEntity.getBody();

        assert apiResponse != null;
        assertEquals(expected, apiResponse.result());
        assertEquals(LocalDateTime.now().getYear(), apiResponse.timestamp().getYear());
    }
}