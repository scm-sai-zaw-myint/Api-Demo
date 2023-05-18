package com.example.demo.api.controllers;

import com.example.demo.api.resources.MockData;
import com.example.demo.api.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public PostResponse createNewPost(@RequestBody PostResponse post){
        PostResponse newPost = new PostResponse(data.getPostLists().size(),data.getFaker().book().title(),data.getFaker().lorem().sentence());
        data.getPostLists().add(newPost);
        return newPost;
    }

    @PutMapping("/{id}")
    public PostResponse updatePost(@PathVariable Integer id, @RequestBody PostResponse post){
        PostResponse oldPost = data.getPostLists().get(id);
        oldPost.setName(post.getName());
        oldPost.setDescription(post.getDescription());
        return oldPost;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deletePost(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        response.put("success", data.getPostLists().remove(data.getPostLists().get(id)));
        return response;
    }
}
