package com.example.demo.web.form;

import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty
    String title;

    String description;

    @NotEmpty
    String license;

    Date createdAt;
}
