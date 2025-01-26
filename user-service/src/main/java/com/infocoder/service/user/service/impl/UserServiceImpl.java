package com.infocoder.service.user.service.impl;

import com.infocoder.service.user.dto.UserDto;
import com.infocoder.service.user.exception.UserNotFoundException;
import com.infocoder.service.user.mapper.UserMapper;
import com.infocoder.service.user.model.User;
import com.infocoder.service.user.repository.UserRepository;
import com.infocoder.service.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        //converting dto to entity
        User user = mapper.toEntity(userDto);

        //saving entity into repository
        User savedUser = userRepository.save(user);

        //again converting entity to dto and return
        return mapper.fromEntity(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        //get user from id
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with this id: " + id));

        //converting entity to dto and return
        return mapper.fromEntity(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();

        //converting List<User> to List<UserDto> and returned to it
        return userList.stream()
                .map(user ->
                        UserDto.builder()
                                .id(user.getId())
                                .fullName(user.getFullName())
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .password(user.getPassword())
                                .role(user.getRole())
                                .phone(user.getPhone())
                                .createdAt(user.getCreatedAt())
                                .updatedAt(user.getUpdatedAt())
                                .build())
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {

        //get user from id
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with this id: " + id));

        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setPhone(userDto.getPhone());
        user.setUpdatedAt(userDto.getUpdatedAt());

        User updatedUser = userRepository.save(user);

        //converting entity to dto and returned it
        return mapper.fromEntity(updatedUser);
    }

    @Override
    public String deleteUser(Long id) {
        //get user from id
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with this id: " + id));

        //deleting the user
        userRepository.delete(user);
        return "User: " + user.getId() + " deleted successfully !!";
    }
}
