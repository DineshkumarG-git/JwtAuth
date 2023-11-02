package com.dinesh.security.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {

    private String firstName ;
    private String lastName ;
    private String email ;
    private String passWord ;
}
