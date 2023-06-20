package com.spring.messaging.listener;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.spring.messaging.annotation.Log;



@Component
public class RestAppEventListener {

	//@EventListener(condition = "#springApp.args.length > 1")
	//@EventListener({CurrencyEvent.class,CurrencyConversionEvent.class})
	//@Order(Ordered.HIGHEST_PRECEDENCE)
	//@Async
	@EventListener
	@Log(printParamsValues=true)	// to intercept in AOP audit classes
	public void restAppHandler(SpringApplicationEvent springApp){
//		System.out.println("------------------------ :" + springApp.getClass()); to print here the event result
	}
}
