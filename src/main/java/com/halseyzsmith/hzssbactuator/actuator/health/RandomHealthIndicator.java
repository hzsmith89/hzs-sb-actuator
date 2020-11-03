package com.halseyzsmith.hzssbactuator.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Random random = new Random();

        if (random.nextBoolean()) {
            return Health.down().withDetail("ERR-RAND", "Random Failure").build();
        }

        return Health.up().build();
    }
}
