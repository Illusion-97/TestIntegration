package fr.dawan.testintegration;

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
}
