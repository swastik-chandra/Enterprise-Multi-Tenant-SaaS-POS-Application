package com.Business.PayLoad.Dto;

import com.Business.Domain.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private UserRole role;
    private String password;
}
