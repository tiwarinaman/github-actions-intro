package com.naman.github.actions.intro.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int addTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }

}
