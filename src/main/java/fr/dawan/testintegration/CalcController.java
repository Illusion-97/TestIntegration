package fr.dawan.testintegration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    private final Randomizer randomizer;

    public CalcController(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    @GetMapping
    public String index() {
        return "Welcome";
    }

    public int divide(int a, int b) {

        boolean test = a == 0
            ? b == 0
                ? true
                : false
            : false;

        return b == 0 ? 0 : a / b;
    }

    public int addition(int a, int b) {
        return a + b;
    }

    /*
     1000 >= Retour >= 0
     */
    public int addToRandom(int a) {
        int result = a + randomizer.getRandomInt();
        if(result > 1000) return 1000;
        else if(result <= 0) return 0;
        return result;
    }
}
