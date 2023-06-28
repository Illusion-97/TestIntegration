package fr.dawan.testintegration;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Randomizer {
    private final Random random = new Random();

    public int getRandomInt() {
        return random.nextInt();
    }
}
