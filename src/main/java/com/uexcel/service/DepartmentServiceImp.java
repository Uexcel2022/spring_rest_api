package com.uexcel.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uexcel.entity.Department;
import com.uexcel.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fatchAlldepartList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No depart with " + id + " found"));

        departmentRepository.deleteById(id);

    }

}
