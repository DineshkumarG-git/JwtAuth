package com.dinesh.security.controller;

import com.dinesh.security.Dto.AuthenticationRequest;
import com.dinesh.security.Dto.AuthenticationResponse;
import com.dinesh.security.Dto.RegisterRequest;
import com.dinesh.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth/api/v1")
public class AuthController {

    private final AuthenticationService authenticationService ;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest)
    {
        // to do implement it
       return   ResponseEntity.ok( authenticationService.register(registerRequest) ) ;
    }

    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest )
    {
         //
      return   ResponseEntity.ok(authenticationService.authenticate(authenticationRequest)) ;
    }

}
