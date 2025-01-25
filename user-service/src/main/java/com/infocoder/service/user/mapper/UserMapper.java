package com.infocoder.service.user.mapper;

import com.infocoder.service.user.dto.UserDto;
import com.infocoder.service.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .phone(userDto.getPhone())
                .createdAt(userDto.getCreatedAt())
                .updatedAt(userDto.getUpdatedAt())
                .build();
    }

    public UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRole())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }


}
