package com.spring.messaging.listener;

import com.spring.messaging.event.CarAddedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CarAddedEventListener implements ApplicationListener<CarAddedEvent> {

	@Override
	public void onApplicationEvent(CarAddedEvent event) {
		log.info("ADDED {} CAR", event.getCar().getModel());
	}
}
