package com.simple.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleArticleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleArticleApiApplication.class, args);
    }

}
