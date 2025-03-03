package com.spring.messaging.listener;

import com.spring.messaging.event.UserAddedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class UserAddedListener {

	//@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	@TransactionalEventListener
	public void processEvent(UserAddedEvent event){
		log.info("USER {} ADDED ", event.getUser().getName());
	}
}
