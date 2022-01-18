package com.example.springproject3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springproject3.Entity.PostUser;

@Repository
public interface PostUserRepository extends JpaRepository<PostUser, Long>{

}
