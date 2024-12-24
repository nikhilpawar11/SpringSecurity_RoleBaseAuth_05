package com.lcwd.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.spring.dto.UserDto;
import com.lcwd.spring.exception.ApiResponseMessage;
import com.lcwd.spring.exception.PegiableResponse;
import com.lcwd.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {

		UserDto savedUser = userService.saveUser(userDto);

		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable String userId) {

		UserDto updateUser = userService.updateUser(userDto, userId);

		return new ResponseEntity<>(updateUser, HttpStatus.OK);

	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId) {

		userService.deleteUser(userId);

		ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
				.message("User deleted successfully " + userId).success(true).status(HttpStatus.OK).build();

		return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);

	}

	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<UserDto> getUserbyId(@PathVariable String userId) {

		UserDto userById = userService.getUserById(userId);

		return new ResponseEntity<>(userById, HttpStatus.OK);

	}

	@GetMapping("/allUser")
	public ResponseEntity<List<UserDto>> getAllUser() {

		List<UserDto> allUser = userService.getAllUser();

		return new ResponseEntity<>(allUser, HttpStatus.OK);

	}

	@GetMapping("/getUserByPegination")
	public ResponseEntity<PegiableResponse> getAllUserWithPegination(
			@RequestParam(name = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "name", required = false) String sortBy,
			@RequestParam(name = "sortDir", defaultValue = "asc", required = false) String sortDir) {

		PegiableResponse userByPegination = userService.getUserByPegination(pageNumber, pageSize, sortBy, sortDir);

		return new ResponseEntity<>(userByPegination, HttpStatus.OK);

	}

}
