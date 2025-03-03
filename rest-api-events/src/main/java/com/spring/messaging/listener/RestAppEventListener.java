package com.spring.messaging.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class RestAppEventListener {

	//@EventListener(condition = "#springApp.args.length > 1")
	//@EventListener({CurrencyEvent.class,CurrencyConversionEvent.class})
	//@Order(Ordered.HIGHEST_PRECEDENCE)
	//@Async
	@EventListener
	public void restAppHandler(SpringApplicationEvent springApp){
		log.info("------------------------ : {}", springApp.getClass()); // to print here the event result
	}
}
