package com.example.springproject3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springproject3.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);

    /*************Metod som tillkallar firstname med Query värden*********/
    //    @Query(value = "SELECT user FROM User user WHERE user.firstname = ?1")
    //    User getTheUserWithFirstName(@Param("firstname") String firstname);

    //User findByFirstName(String firstname);

}
