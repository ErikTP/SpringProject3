package com.example.springproject3.Service;

import com.example.springproject3.Entity.User;
import com.example.springproject3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> GetAllUsers(){
        return userRepository.findAll();
    }

}
