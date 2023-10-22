package com.uexcel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uexcel.entity.Department;
import com.uexcel.exceptionhandler.DataBindingException;
import com.uexcel.exceptionhandler.DepartmentNotFoundException;
import com.uexcel.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department, BindingResult result) {
        LOGGER.info("Inside the post mapping method - Department Controller");
        if (result.hasErrors()) {

            throw new DataBindingException(result.toString());
        }
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> getDepartList() {
        return departmentService.fatchAlldepartList();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmantId) {
        LOGGER.info("Inside Get department by id method - Department controller");
        return departmentService.fetchDepartmentById(departmantId);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside Delete method - Department Controller");
        departmentService.deleteDepartmentById(departmentId);
    }

    // @PutMapping("/departments")
    // public Department putDepartment(@RequestBody Department department) {
    // return departmentService.updateDepartment(department);
    // }

    @PutMapping("/departments/{id}")
    public Department putDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.findDepartmantByName(departmentName);
    }

}
