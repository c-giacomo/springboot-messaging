package com.spring.messaging.listener;

import com.spring.messaging.service.CounterService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class RestApiEventsListener implements ApplicationListener<ApplicationEvent> {
	
	private static final String USERS = "/REST-EVENT/dealership/users";
	private static final String CARS = "/REST-EVENT/dealership/cars";

	private final CounterService counterService;

	public void onApplicationEvent(@NonNull ApplicationEvent event) {
		if (((ServletRequestHandledEvent)event).getRequestUrl().equals(USERS)) {
			counterService.userIncrement();
		} else if (((ServletRequestHandledEvent)event).getRequestUrl().equals(CARS)) {
			counterService.carsIncrement();
		}
	}
}