package com.example.homework.controller;

import com.example.homework.entity.Department;
import com.example.homework.repository.DepartmentRepository;
import com.example.homework.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public String getAll(Model model){
        List<Department> departments = departmentService.getAll();

        model.addAttribute("listDepartment", departments);
        return "index";
    }

    @GetMapping("add")
    public String add(){
        return "add";
    }

    @PostMapping("add/save")
    public String save(@ModelAttribute Department department,Model model){
        departmentService.save(department);
        List<Department> departments = departmentService.getAll();

        model.addAttribute("listDepartment", departments);
        return "redirect:/list";
    }
}
