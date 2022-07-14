package com.mss.tasks.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/user")
	public Map<String, Object> insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}

	@PutMapping("/user")
	public Map<String, Object> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/user")
	public Map<String, Object> deleteUser(@RequestBody User user) {
		return userService.deleteUser(user);
	}

	@GetMapping("/user")
	public List GetUser(User user) {
		return userService.GetUserDetails(user);
	}
}
