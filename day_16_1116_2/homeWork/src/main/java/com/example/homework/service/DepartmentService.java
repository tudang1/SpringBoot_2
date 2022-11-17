package com.example.homework.service;

import com.example.homework.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();

    void save(Department department);
}
