package com.Business.Controller;

import com.Business.Execptions.UserException;
import com.Business.PayLoad.Dto.UserDto;
import com.Business.PayLoad.Response.AuthResponse;
import com.Business.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
// http://localhost:8080/auth/signup
@PostMapping("/signup")
    public ResponseEntity<AuthResponse> signupHandler(
            @RequestBody UserDto userDto
    ) throws UserException {
        return ResponseEntity.ok(
                authService.signup(userDto)
        );
    }
    // http://localhost:8080/auth/login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginHandler(
            @RequestBody UserDto userDto
    ) throws UserException {
        return ResponseEntity.ok(
                authService.login(userDto)
        );
    }

}

// Day 36 audit checkpoint A
// Day 36 audit checkpoint B
// Day 36 audit checkpoint C