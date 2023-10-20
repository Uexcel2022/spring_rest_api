package com.uexcel.service;

import java.util.List;

import com.uexcel.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fatchAlldepartList();

    Department fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Department department);
}
