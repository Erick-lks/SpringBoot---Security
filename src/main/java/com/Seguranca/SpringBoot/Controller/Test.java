package com.Seguranca.SpringBoot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/test")
public class Test {


    @GetMapping()
   public String test (){
        return "Testando Segurança";
    }
    
   
    
}
