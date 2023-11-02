package com.dinesh.security.service;

import com.dinesh.security.Dto.AuthenticationRequest;
import com.dinesh.security.Dto.AuthenticationResponse;
import com.dinesh.security.Dto.RegisterRequest;
import com.dinesh.security.enums.Role;
import com.dinesh.security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class AuthenticationService
{
    private final UserService userService ;
    private final JwtService jwtService ;
    private final PasswordEncoder passwordEncoder ;
    public AuthenticationResponse register(RegisterRequest registerRequest)
    {
        var user = User.builder().email( registerRequest.getEmail()).firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName()).passWord( passwordEncoder.encode(registerRequest.getPassWord()))
                .role(Role.USER).build() ;
        userService.addUser(user);
        var jwtToken  = jwtService.generateToken(user);
         return  AuthenticationResponse.builder().token(jwtToken).build() ;

    }


    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest)
    {
        return  null;
    }

}
