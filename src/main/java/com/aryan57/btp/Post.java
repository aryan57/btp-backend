package com.aryan57.btp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
@Data // generate getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private ObjectId id;

    private String description;

    private String imgLink;

    private int postId;

    private long unixTime;

    public Post(String description, String imgLink, long unixTime) {
        this.description = description;
        this.imgLink = imgLink;
        this.unixTime = unixTime;
    }
}
