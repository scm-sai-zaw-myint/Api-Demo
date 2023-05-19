package com.example.demo.api.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse{
    Integer id;
    String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String description;

    @JsonIgnore
    String license;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createdAt;

}
