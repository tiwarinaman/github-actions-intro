package com.naman.github.actions.intro.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CalculatorService Test Cases")
class CalculatorServiceTest {

    @Test
    @DisplayName("Test adding two positive numbers")
    void addTwoPositiveNumbersTest() {
        // Arrange
        CalculatorService calculatorService = new CalculatorService();
        int num1 = 2;
        int num2 = 3;
        int expected = 5;

        // Act
        int result = calculatorService.addTwoNumbers(num1, num2);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test adding two negative numbers")
    void addTwoNegativeNumbersTest() {
        // Arrange
        CalculatorService calculatorService = new CalculatorService();
        int num1 = -2;
        int num2 = -3;
        int expected = -5;

        // Act
        int result = calculatorService.addTwoNumbers(num1, num2);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test adding zero to a number")
    void addZeroToNumberTest() {
        // Arrange
        CalculatorService calculatorService = new CalculatorService();
        int num1 = 2;
        int num2 = 0;
        int expected = 2;

        // Act
        int result = calculatorService.addTwoNumbers(num1, num2);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test adding two large numbers")
    void addTwoLargeNumbersTest() {
        // Arrange
        CalculatorService calculatorService = new CalculatorService();
        int num1 = 2147483646;
        int num2 = 2147483647;
        int expected = -3;

        // Act
        int result = calculatorService.addTwoNumbers(num1, num2);

        // Assert
        assertEquals(expected, result);
    }
}