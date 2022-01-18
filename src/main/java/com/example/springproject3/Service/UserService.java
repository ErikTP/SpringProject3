package com.example.springproject3.Service;

import com.example.springproject3.Entity.PostUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.springproject3.dto.UserRegistrationDto;
import com.example.springproject3.Entity.User;

import java.util.List;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
