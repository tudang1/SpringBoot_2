package com.example.homework.service;

import com.example.homework.entity.Department;
import com.example.homework.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }
}
