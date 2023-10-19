package com.uexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uexcel.entity.Department;

interface DepartmentRepository extends JpaRepository<Department, Long> {
}
