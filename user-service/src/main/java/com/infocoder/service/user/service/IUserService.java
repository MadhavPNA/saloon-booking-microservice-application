package com.infocoder.service.user.service;

import com.infocoder.service.user.dto.UserDto;

import java.util.List;

public interface IUserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto, Long id);
    String deleteUser(Long id);

}
