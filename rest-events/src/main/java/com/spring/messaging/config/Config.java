package com.spring.messaging.config;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    /*
        call the metrics at /actuator/metrics
        call the registered metric at /actuator/metrics/url.currency.latest.hits
     */

    @Bean
    MeterRegistryCustomizer<MeterRegistry> hitLatestEndpoint() {
        return registry -> registry.config().namingConvention().name("url.currency.latest.hits", Meter.Type.COUNTER);
    }
}
