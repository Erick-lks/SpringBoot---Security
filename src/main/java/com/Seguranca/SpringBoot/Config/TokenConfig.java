package com.Seguranca.SpringBoot.Config;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.Seguranca.SpringBoot.Entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class TokenConfig  {

    private final  String secret = "secret";


    public String generatedToken(User user){

Algorithm algorithm = Algorithm.HMAC256(secret);
         
        return JWT.create()
        .withClaim("userId", user.getId())
        .withSubject(user.getEmail())
        .withExpiresAt(Instant.now().plusSeconds(8600))
        .withIssuedAt(Instant.now())
        .sign(algorithm);
    }
    
}
