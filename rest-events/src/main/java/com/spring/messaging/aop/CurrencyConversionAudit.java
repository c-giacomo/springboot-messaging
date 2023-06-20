package com.spring.messaging.aop;

import com.spring.messaging.event.CurrencyConversionEvent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.spring.messaging.exception.BadCodeRuntimeException;

@Aspect
@Component
public class CurrencyConversionAudit {
	
	
	private ApplicationEventPublisher publisher;
	
	@Autowired // @Autowired is optional here. Spring will know what to do if you omit it.
	public CurrencyConversionAudit(ApplicationEventPublisher publisher){
		this.publisher = publisher;
	}
	
	@Pointcut("execution(* com.apress.messaging.service.*Service.*(..))")
    public void exceptionPointcut() {}
	
	@AfterThrowing(pointcut="exceptionPointcut()", throwing="ex")
	public void badCodeException(JoinPoint jp, BadCodeRuntimeException ex){
		
		if(ex.getConversion()!=null){
			publisher.publishEvent(new CurrencyConversionEvent(jp.getTarget(), ex.getMessage(), ex.getConversion()));
		}
	}
	
}
