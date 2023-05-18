package com.example.demo.api.controllers;

import com.example.demo.api.resources.MockData;
import com.example.demo.api.response.PostResponse;
import com.example.demo.web.form.PostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class ApplicationController {

    @Autowired
    MockData data;
    @GetMapping
    public List<PostResponse> index(){
        return data.getPostLists();
    }

    @GetMapping("/{id}")
    public PostResponse getPostDetail(@PathVariable Integer id){
        return data.getPostLists().get(id);
    }

    @PostMapping()
    public PostResponse createNewPost(@RequestBody PostForm post){
        PostResponse newPost = new PostResponse(
                data.getPostLists().size(),
                post.getTitle(),
                post.getDescription(),
                post.getLicense(),
                new Date());

        data.getPostLists().add(newPost);

        return newPost;
    }

    @PutMapping("/{id}")
    public PostResponse updatePost(@PathVariable Integer id, @RequestBody PostForm post){
        PostResponse oldPost = data.getPostLists().get(id);
        oldPost.setTitle(post.getTitle());
        oldPost.setDescription(post.getDescription());
        oldPost.setLicense(post.getLicense());
        return oldPost;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deletePost(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        response.put("success", data.getPostLists().remove(data.getPostLists().get(id)));
        return response;
    }
}
