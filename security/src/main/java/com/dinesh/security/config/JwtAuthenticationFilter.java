package com.dinesh.security.config;

import com.dinesh.security.service.JwtService;
import com.dinesh.security.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter  extends OncePerRequestFilter {
    @Autowired
    JwtService jwtService ;
    @Autowired
    UserService userDetailService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader  = response.getHeader("Authorization");
        final String jwt ;
        if(authHeader == null || !authHeader.startsWith("Bearer "))
        {
            filterChain.doFilter(request , response);
            return;
        }
        jwt  = authHeader.substring(7) ;
        var userEmail  =  jwtService.extractUserName(jwt);
        if(userEmail!=null  && SecurityContextHolder.getContext().getAuthentication()  == null) // if the user is not authenticated we use to check whether the user is present
        {
             UserDetails userDetails  =  userDetailService.findByEmail(userEmail);
        }

    }
}
