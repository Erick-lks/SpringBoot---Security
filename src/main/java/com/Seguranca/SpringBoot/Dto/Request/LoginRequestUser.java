package com.Seguranca.SpringBoot.Dto.Request;

import jakarta.validation.constraints.NotEmpty;

public record  LoginRequestUser ( @NotEmpty (message = "Email é Obrigatorio!") String email ,
@NotEmpty (message = "A senha é Obrigatoria!") String password) {
    
}
