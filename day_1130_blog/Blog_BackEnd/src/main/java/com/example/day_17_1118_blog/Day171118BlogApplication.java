package com.example.day_17_1118_blog;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Day171118BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day171118BlogApplication.class, args);
    }

    @Bean
    public Faker faker(){
        return new Faker();
    }

    @Bean
    public Slugify slugify(){
        return Slugify.builder().build();
    }
}
