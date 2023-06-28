package fr.dawan.testintegration;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalcControllerTest {
    @Autowired
    CalcController controller;

    @MockBean
    Randomizer randomizer;
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

    @Test
    void givenAIsOneAndBIsOne_whenAddition_thenReturnTwo() {
        int a = 1, b = 1, expected = 2;
        int result = controller.addition(a,b);
        assertEquals(expected, result);
    }

    @Test
    void givenAIsOneAndBIsNegativeOne_whenAddition_thenReturnZero() {
        int a = 1, b = -1, expected = 0;
        int result = controller.addition(a,b);
        assertEquals(expected, result);
    }

    @Test
    void givenAIsNegativeOneAndBIsOne_whenAddition_thenReturnZero() {
        int a = -1, b = 1, expected = 0;
        int result = controller.addition(a,b);
        assertEquals(expected, result);
    }

    @Test
    void givenAIsIntegerMaxValueAndBIsIntegerMaxValue_whenAddition_thenReturnNegativeTwo() {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, expected = -2;
        int result = controller.addition(a,b);
        assertEquals(expected, result);
    }

    @Test
    void givenNegativeSeven_whenAddToRandom_thenReturnZero() {
        int a = -7, expected = 0;

        // Simule l'appel d'une fonction afin de fournir la réponse désirée
        Mockito.when(randomizer.getRandomInt()).thenReturn(7);

        int result = controller.addToRandom(a);

        assertEquals(expected, result);
    }

    @Test
    void givenThousandAndOne_whenAddToRandom_thenReturnThousand() {
        int a = 1001, expected = 1000;

        int result = controller.addToRandom(a);

        assertEquals(expected, result);
    }

    @Test
    void givenNegativeTen_whenAddToRandom_thenReturnZero() {
        int a = -10, expected = 0;

        int result = controller.addToRandom(a);

        assertEquals(expected, result);
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("\u001B[36mCalcControllerTest.beforeEach\u001B[0m");
        Mockito.when(randomizer.getRandomInt()).thenReturn(0);
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("\u001B[36mCalcControllerTest.beforeAll\u001B[0m");
    }

    @AfterEach
    void afterEach() {
        System.out.println("\u001B[36mCalcControllerTest.afterEach\u001B[0m");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\u001B[36mCalcControllerTest.afterAll\u001B[0m");
    }


    @Test
    @Disabled("Unreachable")
    void givenThousand_whenAddToRandom_thenThrowException() {
        int a = 1000;
        Class<? extends Throwable> expected = Exception.class;
        Mockito.when(randomizer.getRandomInt()).thenReturn(7);
        assertThrows(expected, () -> controller.addToRandom(a));
    }

    @Test
    @Disabled("Unreachable")
    void givenZero_whenAddToRandom_thenThrowException() {
        int a = 0;
        Class<? extends Throwable> expected = Exception.class;
        Mockito.when(randomizer.getRandomInt()).thenReturn(0);
        assertThrows(expected, () -> controller.addToRandom(a));
    }
}
