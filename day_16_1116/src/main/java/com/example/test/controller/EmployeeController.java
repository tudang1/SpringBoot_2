package com.example.test.controller;

import com.example.test.entity.Employee;
import com.example.test.repository.EmployeeRepository;
import com.example.test.service.EmployeeService;
import com.example.test.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/home")
    public String home(Model model){
        List<Employee> employees = employeeService.getAll();

        model.addAttribute("listEmployee",employees);
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model,@RequestParam(required = false) String fullName,
                                    @RequestParam(required = false) String email){
        Specification<Employee>  specification = EmployeeSpecification.buildWhere(fullName,email);

        List<Employee> employees = employeeRepository.findAll(specification);
        model.addAttribute("employees",employees);
        return "employeeSearch";
    }

}
