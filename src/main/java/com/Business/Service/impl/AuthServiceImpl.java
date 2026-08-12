package com.Business.Service.impl;

import com.Business.Configration.JwtProvider;
import com.Business.Domain.UserRole;
import com.Business.Execptions.UserException;
import com.Business.Mapper.UserMapper;
import com.Business.Model.User;
import com.Business.PayLoad.Dto.UserDto;
import com.Business.PayLoad.Response.AuthResponse;
import com.Business.Repository.UserRepository;
import com.Business.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomUserImplementation customUserImplementation;

    @Override
    public AuthResponse signup(UserDto userDto) throws UserException {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null) {
            throw new UserException("Email Id is already registered !");
        }
        return null;
    }

    @Override
    public AuthResponse login(UserDto userDto) throws UserException { return null; }
}
