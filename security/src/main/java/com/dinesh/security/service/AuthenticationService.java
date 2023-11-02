package com.dinesh.security.service;

import com.dinesh.security.Dto.AuthenticationRequest;
import com.dinesh.security.Dto.AuthenticationResponse;
import com.dinesh.security.Dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class AuthenticationService
{

    public AuthenticationResponse register(RegisterRequest registerRequest)
    {
        return  null ;
    }


    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest)
    {
        return  null;
    }

}
