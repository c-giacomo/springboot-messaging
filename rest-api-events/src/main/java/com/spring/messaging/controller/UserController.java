package com.spring.messaging.controller;

import com.spring.messaging.model.User;
import com.spring.messaging.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dealership/users")
public class UserController {

	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
	}

	@PostMapping("/buy")
	public ResponseEntity<User> buyCar(@RequestParam("userId") Integer userId, @RequestParam("carCode") Integer carCode) {
		return new ResponseEntity<>(userService.buyCar(userId, carCode), HttpStatus.OK);
	}
	

	
}
