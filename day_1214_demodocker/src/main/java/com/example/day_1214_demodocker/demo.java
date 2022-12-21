package com.example.day_1214_demodocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class demo {
    @GetMapping("/")
    public String show(){
        return "Hello";
    }
}
