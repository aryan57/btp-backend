package com.aryan57.btp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* Most of our businesses logic will be in this service class
* This will handle anything with the api
* */
@Service
public class PostService {

    @Autowired // for automatic initialisation
    private PostRepository postRepository;
    public List<Post> allPosts(){
        return postRepository.findAll();
    }

    public Optional<Post> singlePost(int postId){
        return  postRepository.findPostByPostId(postId);
    }

    public Post createPost(String description,String imgLink,float longitude,float latitude,long unixTime){
        Post post = postRepository.insert(new Post(description, imgLink, longitude, latitude, unixTime));
        return post;
    }
}
