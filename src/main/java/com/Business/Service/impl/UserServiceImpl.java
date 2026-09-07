package com.Business.Service.impl;

import com.Business.Configration.JwtProvider;
import com.Business.Configration.SecurityConfig;
import com.Business.Execptions.UserException;
import com.Business.Model.User;
import com.Business.Repository.UserRepository;
import com.Business.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @Override
    public User getUserFromJwtToken(String token) throws UserException {
        String email = jwtProvider.getEmailFromToken(token);
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UserException("Invalid Token");
        }
        return user;
    }

    @Override
    public User getCurrentUser() throws UserException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user =  userRepository.findByEmail(email);
        if (user == null){
            throw new UserException( "User not found ");
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) throws UserException {
        User user =  userRepository.findByEmail(email);
        if (user == null){
            throw new UserException( "User not found ");
        }

        return user;
    }

    @Override
    public User getUserById(Long Id) throws UserException, Exception {
        return userRepository.findById(Id).orElseThrow(
                ()-> new Exception("User not found")
        );
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

// Day 49 audit checkpoint A