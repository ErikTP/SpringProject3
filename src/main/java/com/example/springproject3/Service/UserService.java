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

    /****************User metod för att kopplas till Repository*******************/
    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow();
    }

//    public void saveUser(User user){
//        String encryptedPass = encryptPassword(user.getPassword(), encryptionKeyProvider());
//        user.setPassword(encryptedPass);
//        userRepository.save(user);
//    }


//    /*****************Funktion som krypterar lösenord******************/
//    private String encryptPassword(String plainTextPass, int encryptionKey){
//        StringBuilder sb = new StringBuilder();
//        char [] chars = plainTextPass.toCharArray();
//        for (char c: chars){
//            c = (char) (c+ encryptionKey);
//            sb.append(c);
//        }
//        return sb.toString();
//    }
//
//    /****************Funktion som ger oss krypteringsnyckel*******************/
//    private int encryptionKeyProvider(){
//        return 3;
//    }


//    public boolean authUser(User user) {
//        User dbUser = userRepository.getTheUserWithFirstName(user.getFirstname());
//        if(dbUser == null){
//            System.out.println("Your name is not correct " + user.getFirstname());
//        return false;
//        }
//
//        String encryptedPass = encryptPassword(user.getPassword(), encryptionKeyProvider());
//
//       return encryptedPass.equals(dbUser.getPassword());
//
//    }

//    public boolean authUser(String firstname, String password) {
//        User dbUser = userRepository.findByFirstName(firstname);
//        if (dbUser == null) {
//            System.out.println("Your name is not correct " + firstname);
//            return false;
//        }
//
//        String encryptedPass = encryptPassword(password, encryptionKeyProvider());
//
//        return encryptedPass.equals(dbUser.getPassword());
//
//    }

}
