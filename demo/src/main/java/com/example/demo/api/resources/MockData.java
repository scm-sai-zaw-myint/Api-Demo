package com.example.demo.api.resources;

import com.example.demo.api.response.PostResponse;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Getter
public class MockData {
    final Faker faker = new Faker();

    List<PostResponse> postLists = new ArrayList<>();

    @PostConstruct
    void generateData() {
        for (int i = 0; i < 10; i++) {
            String description = i%2 == 0 ? faker.lorem().sentence() : null;
            postLists.add(new PostResponse(i, faker.book().title(), description, faker.lorem().sentence(), new Date()));
        }
    }

    public PostResponse getPostById(int id) {
        PostResponse post = null;
        for(PostResponse p : this.getPostLists()){
            if(p.getId() == id){
                post = p;
            }
        }
        return post;
    }

    public void addNewPost(PostResponse post) {
        post.setId(this.getPostLists().size());
        post.setCreatedAt(new Date());
        this.getPostLists().add(post);
    }
}
