package com.naman.github.actions.intro.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naman.github.actions.intro.domain.ApiResponse;
import com.naman.github.actions.intro.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Calculator Integration Test Cases")
class CalculatorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test adding two positive numbers using controller")
    void addTwoPositiveNumbersTest() throws Exception {
        // Arrange
        int num1 = 2;
        int num2 = 3;
        int expected = num1 + num2;

        // Act
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(new URI("/api/v1/calculator/" + num1 + "/" + num2))
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        ApiResponse response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ApiResponse.class);
        assertThat(mvcResult.getResponse().getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(response.result(), equalTo(expected));
    }

    @Test
    @DisplayName("Test adding two negative numbers using controller")
    void addTwoNegativeNumbersTest() throws Exception {
        // Arrange
        int num1 = -2;
        int num2 = -3;
        int expected = num1 + num2;

        // Act
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(new URI("/api/v1/calculator/" + num1 + "/" + num2))
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        ApiResponse response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ApiResponse.class);
        assertThat(mvcResult.getResponse().getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(response.result(), equalTo(expected));
    }

    @Test
    @DisplayName("Test adding zero to a number using controller")
    void addZeroToNumberTest() throws Exception {
        // Arrange
        int num1 = 2;
        int num2 = 0;
        int expected = num1 + num2;

        // Act
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(new URI("/api/v1/calculator/" + num1 + "/" + num2))
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        ApiResponse response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ApiResponse.class);
        assertThat(mvcResult.getResponse().getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(response.result(), equalTo(expected));
    }

    @Test
    @DisplayName("Test adding two large numbers using controller")
    void addTwoLargeNumbersTest() throws Exception {
        // Arrange
        int num1 = 2147483646;
        int num2 = 86878887;
        int expected = num1 + num2;

        // Act
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(new URI("/api/v1/calculator/" + num1 + "/" + num2))
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        ApiResponse response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ApiResponse.class);
        assertThat(mvcResult.getResponse().getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(response.result(), equalTo(expected));
    }

    @Test
    @DisplayName("Test adding two numbers using service")
    void addTwoNumbersServiceTest() {
        // Arrange
        int num1 = 2;
        int num2 = 3;
        int expected = num1 + num2;

        // Act
        int result = calculatorService.addTwoNumbers(num1, num2);

        // Assert
        assertThat(result, equalTo(expected));
    }

}
