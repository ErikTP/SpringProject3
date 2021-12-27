package com.example.springproject3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springproject3.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
