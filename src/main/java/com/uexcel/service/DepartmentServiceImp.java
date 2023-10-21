package com.uexcel.service;

import java.util.List;
import java.util.Objects;

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
    public Department fetchDepartmentById(Long departmantId) {
        return departmentRepository.findById(
                departmantId)
                .orElseThrow(
                        () -> new DepartmentNotFoundException("No department found"));

    }

    @Override
    public void deleteDepartmentById(Long departmantId) {
        departmentRepository.findById(departmantId).orElseThrow(
                () -> new DepartmentNotFoundException("No department found"));

        departmentRepository.deleteById(departmantId);

        throw new DepartmentNotFoundException("The department has been deleted.");

    }

    // @Override
    // public Department updateDepartment(Department newDepartment) {
    // return
    // departmentRepository.findById(newDepartment.getDepartmentId()).map(department
    // -> {
    // department.setDepartmantName(newDepartment.getDepartmantName());
    // department.setdepartmentAddress(newDepartment.getdepartmentAddress());
    // department.setDepartmentCode(newDepartment.getDepartmentCode());
    // return departmentRepository.save(newDepartment);
    // }).orElseThrow(
    // () -> new DepartmentNotFoundException(
    // "There is no department having id " + newDepartment.getDepartmentId()));
    // }

    @Override
    public Department updateDepartment(Long departmantId, Department newDepartment) {
        Department department = departmentRepository.findById(departmantId).orElseThrow(
                () -> new DepartmentNotFoundException("No department found"));

        if (Objects.nonNull(newDepartment.getDepartmantName())
                && !"".equalsIgnoreCase(newDepartment.getDepartmantName())) {
            department.setDepartmantName(newDepartment.getDepartmantName());

        }

        if (Objects.nonNull(newDepartment.getDepartmentCode())
                && !"".equalsIgnoreCase(newDepartment.getDepartmentCode())) {
            department.setDepartmentCode(newDepartment.getDepartmentCode());

        }

        if (Objects.nonNull(newDepartment.getDepartmentAddress())
                && !"".equalsIgnoreCase(newDepartment.getDepartmentAddress())) {
            department.setDepartmentAddress(newDepartment.getDepartmentAddress());

        }

        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmantByName(String departmantName) {

        Department department = departmentRepository.findByDepartmantNameIgnoreCase(departmantName);
        if (Objects.isNull(department)) {

            throw new DepartmentNotFoundException("No department found");
        }
        return departmentRepository.findByDepartmantNameIgnoreCase(departmantName);
    }
}
