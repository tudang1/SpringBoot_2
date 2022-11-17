package com.example.day_1109_demosecurity.controller;

import com.example.day_1109_demosecurity.entity.Product;
import com.example.day_1109_demosecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String home(Model model){
        List<Product> products = productService.getAll();

        model.addAttribute("listProduct",products);

        return "index";
    };

    @GetMapping("product-add")
    public String add(){

        return "product-add";
    };

    @PostMapping("product/save")
    public String save(@ModelAttribute Product product,Model model){

        System.out.println(product);
        productService.save(product);
        List<Product> products = productService.getAll();
        model.addAttribute("listProduct",products);

        return "index";
    }

}
