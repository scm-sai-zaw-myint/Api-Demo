package com.example.demo.api.resources;

import com.example.demo.api.response.PostResponse;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class MockData {
    final Faker faker = new Faker();

    List<PostResponse> postLists = new ArrayList<>();
    @PostConstruct
    void generateData(){
        for (int i = 0; i < 10 ; i++) {
            postLists.add(new PostResponse(
                    i,faker.book().title(),faker.lorem().sentence()
            ));
        }
    }

}
