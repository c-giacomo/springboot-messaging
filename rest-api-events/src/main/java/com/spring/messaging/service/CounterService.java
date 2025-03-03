package com.spring.messaging.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private final Counter usersHitCounter;
    private final Counter carsHitCounter;

    public CounterService(MeterRegistry registry) {
        this.usersHitCounter = registry.counter("url.users.hits");
        this.carsHitCounter = registry.counter("url.cars.hits");
    }

    public void userIncrement() {
        this.usersHitCounter.increment();
    }
    public void carsIncrement() { this.carsHitCounter.increment(); }
}
