package com.example.springproject3.Service;

import java.util.List;
import java.util.Optional;

import com.example.springproject3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springproject3.Entity.PostUser;
import com.example.springproject3.Repository.PostUserRepository;

@Service
public class PostUserServiceImpl implements PostUserService {

    @Autowired
    private PostUserRepository postUserRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PostUser> getAllPostUsers() {
        return postUserRepository.findAll();
    }

    @Override
    public void savePostUser(PostUser userPost) {
        this.postUserRepository.save(userPost);
    }

    @Override
    public PostUser getPostUserById(long id) {
        Optional<PostUser> optional = postUserRepository.findById(id);
        PostUser postUser = null;
        if (optional.isPresent()) {
            postUser = optional.get();
        } else {
            throw new RuntimeException(" PostUser not found for id :: " + id);
        }
        return postUser;
    }

    @Override
    public void deletePostUserById(long id) {
        this.postUserRepository.deleteById(id);
    }

    @Override
    public Page<PostUser> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.postUserRepository.findAll(pageable);
    }

    /*****************Metoder som både sparar och hämtar lista av jobb**************/
//    public void saveJob(Job job){
//        jobRepository.save(job);
//    }
//
//    public List<Job> getAllJobs(){
//        return jobRepository.findAll();
//    }

}
