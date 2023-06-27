package fr.dawan.testintegration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalcControllerTest {
    @Autowired
    CalcController controller;

    @Test
    void index() {
        assertEquals("Welcome", controller.index());
    }

    @Test
    void divide() {
        assertEquals(1, controller.divide(1,1));
    }

    @Test
    void givenOneAndOne_whenDivide_thenReturnOne() {
        // Arrange (Déclaration de paramètres)
        int a = 1, b = 1, expected = 1;

        // Act
        int result = controller.divide(a,b);

        // Assert
        assertEquals(expected , result);
    }

    @Test
    void givenOneAndZero_whenDivide_thenReturnZero() {
        int a = 0, b = 1, expected = 0;

        int result = controller.divide(a,b);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("DivideByZero")
    @Disabled("Fixed -> givenAIsOneAndBIsZero_whenDivide_thenReturnZero")
    void givenAIsOneAndBIsZero_whenDivide_thenThrowArithmeticException() {
        int a = 1, b = 0;

        Class<? extends Throwable> expected = ArithmeticException.class;

        assertThrows(expected, () -> controller.divide(a,b));
    }

    @Test
    @DisplayName("DivideByZero")
    void givenAIsOneAndBIsZero_whenDivide_thenReturnZero() {
        int a = 1, b = 0, expected = 0;
        int result = controller.divide(a,b);
        assertEquals(expected, result);
    }



}
