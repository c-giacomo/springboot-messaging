package com.spring.messaging.service;

import com.spring.messaging.event.CarBuyedEvent;
import com.spring.messaging.event.UserAddedEvent;
import com.spring.messaging.model.Car;
import com.spring.messaging.model.User;
import com.spring.messaging.repository.CarRepository;
import com.spring.messaging.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ApplicationEventPublisher publisher;
	
    @Transactional
    public User saveUser(User user) {
        User saved = userRepository.save(user);
        publisher.publishEvent(new UserAddedEvent(this, saved));
        return saved;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public User buyCar(Integer userId, Integer carCode) {
        Optional<User> u = userRepository.findById(userId);
        Optional<Car> c = carRepository.findById(carCode);
        if (u.isEmpty() || c.isEmpty()) throw new RuntimeException("User or Car not found");

        List<Car> cars = u.get().getCars();
        cars.add(c.get());

        publisher.publishEvent(new CarBuyedEvent(this, u.get(), c.get()));
        return userRepository.save(u.get());
    }
	
}
