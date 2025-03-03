package com.spring.messaging.listener;

import com.spring.messaging.event.CarBuyedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CarBuyedEventListener implements ApplicationListener<CarBuyedEvent> {

    @Override
    public void onApplicationEvent(CarBuyedEvent event) {
        log.info("USER {} HAS BUYED CAR {}", event.getUser().toString(), event.getCar().toString());
    }
}
