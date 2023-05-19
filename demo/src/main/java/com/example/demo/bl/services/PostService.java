package com.example.demo.bl.services;

import com.example.demo.api.response.PostResponse;
import com.example.demo.web.form.PostForm;

import java.util.List;

public interface PostService {
    public List<PostResponse> getPostList();
    public PostResponse getPostById(Integer id);
    public PostResponse createPost(PostForm form);
    public PostResponse updatePost(Integer id,PostForm form);
    public boolean deletePost(Integer id);
}
