package com.example.springproject3.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.springproject3.Entity.PostUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springproject3.dto.UserRegistrationDto;
import com.example.springproject3.Entity.Role;
import com.example.springproject3.Entity.User;
import com.example.springproject3.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    /**************Metoder för att både spara och hämta lista av användare***********/
//    public void saveUser(User user){
//        userRepository.save(user);
//    }
//
//    public List<User> GetAllUsers(){
//        return userRepository.findAll();
//    }
//
    /*******************User metoder för att kopplas till Repository*******************/
//    public User getUserByName(String name){
//        return userRepository.findByName(name);
//    }
//
//    public User getUserById(Long id){
//        return userRepository.findById(id).orElseThrow();
//    }

    /*************************Funktioner som krypterar lösenord*********************/

    //    public void saveUser(User user){
//        String encryptedPass = encryptPassword(user.getPassword(), encryptionKeyProvider());
//        user.setPassword(encryptedPass);
//        userRepository.save(user);
//    }

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
    /****************Funktion som ger oss krypteringsnyckel*******************/
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
