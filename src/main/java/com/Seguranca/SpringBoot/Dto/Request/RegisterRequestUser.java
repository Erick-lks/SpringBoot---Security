package com.Seguranca.SpringBoot.Dto.Request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterRequestUser ( @NotEmpty(message ="Nome é obrigatório!") String name, @NotEmpty (message = "Email é Obrigatorio!") String email ,
@NotEmpty(message = "A senha é Obrigatoria!") String password ) {
    
}
