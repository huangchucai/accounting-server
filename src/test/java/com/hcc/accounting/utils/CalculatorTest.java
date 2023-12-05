package com.hcc.accounting.utils;

import lombok.val;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    @DisplayName("first test case")
        //    @RepeatedTest(5)
        //    @Disabled
    void testAdd() {
        // Arrange (准备数据）
        int num1 = 100;
        int num2 = 200;
        // Act (执行测试）
        val calculator = new Calculator();
        int result = calculator.add(num1, num2);
        // Assert (断言结果）
        assertEquals(300, result);
    }
}
