package com.Seguranca.SpringBoot.Dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record  LoginRequestUser ( @NotEmpty (message = "Email é Obrigatorio!") 
       @Email(message = "Email inválido") String email ,
@NotEmpty (message = "A senha é Obrigatoria!") String password) {
    
}
