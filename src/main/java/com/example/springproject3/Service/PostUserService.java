package com.example.springproject3.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.springproject3.Entity.PostUser;

public interface PostUserService {
    List<PostUser> getAllPostUsers();

    void savePostUser(PostUser postUser);

    PostUser getPostUserById(long id);

    void deletePostUserById(long id);

    Page<PostUser> findPaginated(int pageNo, int pageSize);
}
