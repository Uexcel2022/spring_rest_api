package com.uexcel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
                        () -> new DepartmentNotFoundException("Department not available"));

    }

    @Override
    public ReturnDeleteMessage deleteDepartmentById(Long departmantId) {

        String time = LocalDateTime.now().toString().substring(0, LocalDateTime.now().toString().indexOf("."))
                .replace("T", " ");
        ReturnDeleteMessage msg;

        Optional<Department> dpt = departmentRepository.findById(departmantId);
        if (dpt.isPresent()) {
            departmentRepository.deleteById(departmantId);
            msg = new ReturnDeleteMessage(time, HttpStatus.OK, "The department has been deleted successfully");
            return msg;
        }
        msg = new ReturnDeleteMessage(time, HttpStatus.NOT_FOUND, "The department is not available");

        return msg;

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
                () -> new DepartmentNotFoundException("Department not available"));

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

            throw new DepartmentNotFoundException("Department not available");
        }
        return departmentRepository.findByDepartmantNameIgnoreCase(departmantName);
    }
}
