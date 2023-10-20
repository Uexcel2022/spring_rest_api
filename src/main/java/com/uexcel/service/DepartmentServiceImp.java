package com.uexcel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uexcel.entity.Department;
import com.uexcel.exceptionhandler.DepartmentNotFoundException;
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
                .orElseThrow(
                        () -> new DepartmentNotFoundException("There is no department having id " + id));

    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.findById(id)
                .orElseThrow(
                        () -> new DepartmentNotFoundException("There is no department having id " + id));

        departmentRepository.deleteById(id);

        throw new DepartmentNotFoundException("Department deleted.");

    }

    @Override
    public Department updateDepartment(Department newDepartment) {
        return departmentRepository.findById(newDepartment.getDepartmentId()).map(department -> {
            department.setDepartmantName(newDepartment.getDepartmantName());
            department.setdepartmentAddress(newDepartment.getdepartmentAddress());
            department.setDepartmentCode(newDepartment.getDepartmentCode());
            return departmentRepository.save(newDepartment);
        }).orElseThrow(
                () -> new DepartmentNotFoundException(
                        "There is no department having id " + newDepartment.getDepartmentId()));
    }

}
