package com.example.demo.web.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostForm {
    Integer id;
    String title;
    String description;
    String license;
    Date createdAt;
}
