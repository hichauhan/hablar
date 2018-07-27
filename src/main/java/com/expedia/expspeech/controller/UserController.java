package com.expedia.expspeech.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expedia.expspeech.POJO.User;
import com.expedia.expspeech.repository.UserRepository;

@Controller @RequestMapping(path = "/user") public class UserController {
	@Autowired private UserRepository userRepository;

	@PostMapping(path = "/add") public @ResponseBody String addUser(@RequestBody User user) {
		userRepository.save(user);
		return "Saved";
	}

	@GetMapping(path = "/") public @ResponseBody Optional<User> getAllUsers(@RequestParam int id) {
		// This returns a JSON or XML with the users
		return userRepository.findById(id);
	}
}
