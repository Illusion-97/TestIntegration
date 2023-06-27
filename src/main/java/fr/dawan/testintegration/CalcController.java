package fr.dawan.testintegration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @GetMapping
    public String index() {
        return "Welcome";
    }

    public int divide(int a, int b) {
        return b == 0 ? 0 : a / b;
    }

    public int addition(int a, int b) {
        return a + b;
    }
}
