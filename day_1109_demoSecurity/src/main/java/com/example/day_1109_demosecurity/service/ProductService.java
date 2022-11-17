package com.example.day_1109_demosecurity.service;

import com.example.day_1109_demosecurity.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void save(Product product);
}
