package com.aryan57.btp;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
* data access layer of api
* talks to database and get the datta back
* */
@Repository
public interface PostRepository extends MongoRepository<Post, ObjectId> {

    /*
    * This is a dynamic query
    * postId is a member of post class
    * and naming the function as findPostBy<Member> will
    * automatically do the job
    * */
    Optional<Post> findPostByPostId(int postId);
}
