package com.example.swagger.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {



    @GetMapping
    public String getAll(){
        return "list data";
    }

    @PostMapping
    public String save(){
        return "Save Success";
    }

    @PutMapping
    public String update(){
        return "Update Success";
    }
}
