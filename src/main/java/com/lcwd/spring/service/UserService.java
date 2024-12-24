package com.lcwd.spring.service;

import java.util.List;

import com.lcwd.spring.dto.UserDto;
import com.lcwd.spring.exception.PegiableResponse;

public interface UserService {

	public UserDto saveUser(UserDto userDto);

	public UserDto updateUser(UserDto userDto, String userId);

	public void deleteUser(String userId);

	public UserDto getUserById(String userId);

	public List<UserDto> getAllUser();

	public PegiableResponse getUserByPegination(int pageNumber, int pageSize, String sortBy, String sortDir);

}
