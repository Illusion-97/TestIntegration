package fr.dawan.testintegration;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    public String index() {
        return "Welcome";
    }
}
