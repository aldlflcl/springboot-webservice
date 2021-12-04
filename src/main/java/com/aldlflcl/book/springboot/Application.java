package com.aldlflcl.book.springboot;

import com.aldlflcl.book.springboot.domain.posts.Posts;
import com.aldlflcl.book.springboot.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;

@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class Application {

    private final PostsRepository postsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        Posts posts = Posts.builder()
                .title("타이틀")
                .author("작가")
                .content("내용")
                .build();

        postsRepository.save(posts);
    }
}
