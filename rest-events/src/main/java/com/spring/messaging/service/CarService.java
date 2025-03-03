package com.spring.messaging.service;

import com.spring.messaging.event.CarAddedEvent;
import com.spring.messaging.model.Car;
import com.spring.messaging.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public Car saveCar(Car car) {
        Car saved = carRepository.save(car);
        publisher.publishEvent(new CarAddedEvent(this, saved));
        return saved;
    }

    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Car findById(Integer id) {
       return carRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
