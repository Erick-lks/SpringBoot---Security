package com.Seguranca.SpringBoot.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Seguranca.SpringBoot.Dto.Request.LoginRequestUser;
import com.Seguranca.SpringBoot.Dto.Request.RegisterRequestUser;
import com.Seguranca.SpringBoot.Dto.Response.LoginResponseUser;
import com.Seguranca.SpringBoot.Dto.Response.RegisterUserResponse;
import com.Seguranca.SpringBoot.Entity.User;
import com.Seguranca.SpringBoot.Repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
  
    
    private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
   private final AuthenticationManager authenticationManager;

      public AuthController (UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
        this.authenticationManager=authenticationManager;
      }
    
  
    @PostMapping("/login")
    public ResponseEntity<LoginResponseUser> login(@Valid @RequestBody LoginRequestUser request){

      UsernamePasswordAuthenticationToken userandPass = new UsernamePasswordAuthenticationToken(request.email(),request.password());
      Authentication authentication = authenticationManager.authenticate(userandPass);
      
        return null;
    }
    

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register (@Valid @RequestBody RegisterRequestUser request){
      User newUser = new User();
      newUser.setPassword(passwordEncoder.encode(request.password()));
      newUser.setEmail(request.email());
      newUser.setName(request.name());
      
      userRepository.save(newUser);


  
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new RegisterUserResponse(newUser.getName() ,newUser.getEmail()));
    }
}
