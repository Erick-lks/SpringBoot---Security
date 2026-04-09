package com.Seguranca.SpringBoot.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.Seguranca.SpringBoot.Entity.User;

public interface  UserRepository extends JpaRepository<User, Long> {
    Optional<UserDetails> findUserByEmail(String username);
    
}
