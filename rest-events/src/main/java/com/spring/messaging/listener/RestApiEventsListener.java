package com.spring.messaging.listener;

import com.spring.messaging.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import com.spring.messaging.annotation.Log;

@Component
public class RestApiEventsListener implements ApplicationListener<ApplicationEvent>{
	
	private static final String LATEST = "/currency/latest";
	
	@Autowired
	private CounterService counterService;
	
	@Log(printParamsValues=true)
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof ServletRequestHandledEvent){
			if(((ServletRequestHandledEvent)event).getRequestUrl().equals(LATEST)){
				counterService.increment();
			}
		}
	}
}