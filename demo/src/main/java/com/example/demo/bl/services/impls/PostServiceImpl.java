package com.example.demo.bl.services.impls;

import com.example.demo.api.resources.MockData;
import com.example.demo.api.response.PostResponse;
import com.example.demo.bl.services.PostService;
import com.example.demo.web.form.PostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private MockData data;
    @Override
    public List<PostResponse> getPostList() {
        return data.getPostLists();
    }

    @Override
    public PostResponse getPostById(Integer id) {
        return data.getPostById(id);
    }

    @Override
    public PostResponse createPost(PostForm form) {
        PostResponse newPost = new PostResponse();
        newPost.setTitle(form.getTitle());
        newPost.setLicense(form.getLicense());
        newPost.setDescription(form.getDescription());
        data.addNewPost(newPost);
        return newPost;
    }

    @Override
    public PostResponse updatePost(Integer id,PostForm form) {
        PostResponse post = this.getPostById(id);
        if(form.getTitle() != null) {
            post.setTitle(form.getTitle());
        }
        if(form.getDescription() != null) {
            post.setDescription(form.getDescription());
        }
        if(form.getLicense() != null) {
            post.setLicense(form.getLicense());
        }
        return post;
    }

    @Override
    public boolean deletePost(Integer id) {
        return data.getPostLists().remove(this.getPostById(id));
    }
}
