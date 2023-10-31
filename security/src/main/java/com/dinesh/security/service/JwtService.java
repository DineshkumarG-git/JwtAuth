package com.dinesh.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.function.Function;

@Service
public class JwtService {

    private  static  final String  secretKey  = "pK9cy3E5yTVJpUJtHip/zS0EbtVw0Iy1YLcdIKsGq8yCikD/HUKPGEVAtVDiAYa5";
    public String extractUserName(String token)
    {

        return extractClaim(token , Claims::getSubject) ;
    }

    public <T> T extractClaim(String token , Function<Claims,T> claimResolver)
    {
        Claims claims  = extractAllClaims(token);
       return   claimResolver.apply(claims) ;
    }

    private Claims extractAllClaims(String token) // used to extract all claims
    {
        return Jwts.parserBuilder().setSigningKey(getSingInKey()).build()
                .parseClaimsJwt(token).getBody() ;
    }
    private Key getSingInKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}
