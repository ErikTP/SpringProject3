package com.example.springproject3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springproject3.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

//    @Query(value = "SELECT user FROM User user WHERE user.firstname = ?1")
//    User getTheUserWithFirstName(@Param("firstname") String firstname);

//User findByFirstName(String firstname);

}
