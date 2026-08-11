package com.Business.Service;

import com.Business.Execptions.UserException;
import com.Business.PayLoad.Dto.UserDto;
import com.Business.PayLoad.Response.AuthResponse;

public interface AuthService {
    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;

}
