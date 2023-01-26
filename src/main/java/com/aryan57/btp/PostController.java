package com.aryan57.btp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/*
* Only handles the api
* don't know anything about the database
* just calls the service class
* */

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(postService.allPosts(), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Optional<Post>> getSinglePost(@PathVariable int postId){
        return new ResponseEntity<>(postService.singlePost(postId), HttpStatus.OK);
    }

    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(@RequestBody Post payload){
        System.out.println(payload);
        return  new ResponseEntity<>(postService.createPost(payload.getDescription(),payload.getImgLink(), payload.getUnixTime()),HttpStatus.CREATED);
    }
}
