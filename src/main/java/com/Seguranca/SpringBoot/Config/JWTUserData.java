package com.Seguranca.SpringBoot.Config;

import lombok.Builder;

@Builder
public record JWTUserData (Long userId , String email){
    
}
