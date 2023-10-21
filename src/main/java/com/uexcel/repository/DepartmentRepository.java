package com.uexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uexcel.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmantName(String departmantName);

    public Department findByDepartmantNameIgnoreCase(String departmantName);
}
