package com.uexcel.service;

import java.util.List;

import com.uexcel.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fatchAlldepartList();

    Department fetchDepartmentById(Long id);

    void deleteDepartmentById(Long id);

    Department updateDepartment(Department department);
}
