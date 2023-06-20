package com.spring.messaging.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private final Counter latestHitCounter;

    public CounterService(MeterRegistry registry) {
        this.latestHitCounter = registry.counter("url.currency.latest.hits");
    }

    public void increment() {
        this.latestHitCounter.increment();
    }
}
