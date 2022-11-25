package com.example.testjpa_1123;

import com.example.testjpa_1123.entity.Employee;
import com.example.testjpa_1123.repository.EmployeeRepository;
import com.github.javafaker.Faker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TestJpa1123Application {

    public static void main(String[] args) {
        SpringApplication.run(TestJpa1123Application.class, args);
    }

    @Bean
    public Faker faker(){
        return new Faker();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
