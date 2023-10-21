package com.uexcel.service;

import java.util.List;
import java.util.Optional;

import com.uexcel.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fatchAlldepartList();

    Department fetchDepartmentById(Long departmantId);

    void deleteDepartmentById(Long departmantId);

    Department updateDepartment(Long departmantId, Department department);

    Department findDepartmantByName(String departmantName);
}
