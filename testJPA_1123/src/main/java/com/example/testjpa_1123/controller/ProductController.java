package com.example.testjpa_1123.controller;

import com.example.testjpa_1123.entity.Product;
import com.example.testjpa_1123.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("Not found Product with id = "+ id);
        });
    }

}
