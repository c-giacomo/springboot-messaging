package com.spring.messaging.event;

import com.spring.messaging.model.Car;
import com.spring.messaging.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CarBuyedEvent extends ApplicationEvent {
    private User user;
    private Car car;

    public CarBuyedEvent(Object source, User user, Car car) {
        super(source);
        this.user = user;
        this.car = car;
    }
}
