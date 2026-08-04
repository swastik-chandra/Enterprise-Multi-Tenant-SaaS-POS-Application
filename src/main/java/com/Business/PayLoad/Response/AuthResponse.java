package com.Business.PayLoad.Response;

import com.Business.PayLoad.Dto.UserDto;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private UserDto user;


}
