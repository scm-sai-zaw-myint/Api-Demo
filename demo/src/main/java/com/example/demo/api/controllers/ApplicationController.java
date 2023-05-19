package com.example.demo.api.controllers;

import com.example.demo.api.commons.APICommon;
import com.example.demo.api.response.CommonResponse;
import com.example.demo.bl.services.PostService;
import com.example.demo.web.form.PostForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/post")
public class ApplicationController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<CommonResponse> index() {
        CommonResponse response = new CommonResponse(true, "Get posts list successfully!", new Date(), postService.getPostList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getPostDetail(@PathVariable Integer id) {
        CommonResponse response = new CommonResponse();
        response.setSuccess(true);
        response.setMessage("Get post detail successfully!");
        response.setTimestamp(new Date());
        response.setData(postService.getPostById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CommonResponse> createNewPost(@Valid @RequestBody PostForm post, BindingResult result) {
        if (result.hasErrors()) {
            CommonResponse errorResponse = new CommonResponse(false, "Error while creating new post!", new Date());
            errorResponse.setData(APICommon.getErrorMessages(result));
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        CommonResponse common = new CommonResponse(true, "Create new post successfully!", new Date());
        common.setData(this.postService.createPost(post));
        return new ResponseEntity<>(common, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updatePost(@PathVariable Integer id, @RequestBody PostForm post) {
        if (post.getTitle() == null || post.getDescription() == null || post.getLicense() == null) {
            CommonResponse errorResponse = new CommonResponse(false, "The request must have at least one field to update!", new Date());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        CommonResponse response = new CommonResponse(true, "Successfully updated post", new Date());
        response.setData(this.postService.updatePost(id, post));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deletePost(@PathVariable Integer id) {
        boolean success = this.postService.deletePost(id);
        CommonResponse commonResponse = new CommonResponse(success, success ? "Delete post success!" : "No post has been deleted!", new Date());
        return new ResponseEntity<>(commonResponse, success ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
