package com.spring.messaging.event;

import com.spring.messaging.model.Car;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CarAddedEvent extends ApplicationEvent {
    private Car car;

    public CarAddedEvent(Object source, Car car) {
        super(source);
        this.car = car;
    }
}
