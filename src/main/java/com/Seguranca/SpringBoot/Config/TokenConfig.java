package com.Seguranca.SpringBoot.Config;

import java.time.Instant;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.Seguranca.SpringBoot.Entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

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


    public Optional<JWTUserData> validatedToken(String token) {

try {
      
        Algorithm algorithm = Algorithm.HMAC256(secret);

        DecodedJWT decode = JWT.require(algorithm).build().verify(token);

        return Optional.of(JWTUserData.builder()
    .userId(decode.getClaim("userId").asLong())
    .email(decode.getSubject()).build());
    
} catch (JWTVerificationException exception) {

    return Optional.empty();
}
}
}