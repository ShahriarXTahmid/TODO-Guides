package com.example.todoguides;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoGuidesApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    static void main(String[] args) {
        SpringApplication.run(TodoGuidesApplication.class, args);
    }

}
