package com.example.demosecurity.controller;

import com.example.demosecurity.entity.Product;
import com.example.demosecurity.repository.ProductRepository;
import com.example.demosecurity.request.UpdateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> creatProduct(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateProduct request){
        return null;
    }

}
