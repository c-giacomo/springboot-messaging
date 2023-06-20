package com.spring.messaging.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.spring.messaging.annotation.Log;
import com.spring.messaging.event.CurrencyEvent;

@Component
public class RateEventListener {

	//@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	@TransactionalEventListener
	@Log(printParamsValues=true,callMethodWithNoParamsToString="getRate")	// to intercept in AOP audit classes
	public void processEvent(CurrencyEvent event){
	//	System.out.println("------------------------- " + event.getRate());  to print here te event result
	}
}
