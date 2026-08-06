package com.Business.Mapper;

import com.Business.Model.User;
import com.Business.PayLoad.Dto.UserDto;

public class UserMapper {
    public static UserDto toDTO(User savedUser) {
        UserDto userDto = new UserDto();
       userDto.setId(savedUser.getId());
       userDto.setFullName(savedUser.getFullName());
       userDto.setEmail(savedUser.getEmail());
       userDto.setRole(savedUser.getRole());
       userDto.setCreatedAt(savedUser.getCreatedAt());
       userDto.setUpdatedAt(savedUser.getUpdatedAt());
       userDto.setLastLoginAt(savedUser.getLastLogin());
       userDto.setPhone(savedUser.getPhone());


        return userDto;

    }
}
