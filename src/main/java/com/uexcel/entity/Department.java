package com.uexcel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmantName;
    private String departmentAddress;
    private String departmentCode;

    public Department(Long departmentId, String departmantName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmantName = departmantName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmantName() {
        return departmantName;
    }

    public void setDepartmantName(String departmantName) {
        this.departmantName = departmantName;
    }

    public String getdepartmentAddress() {
        return departmentAddress;
    }

    public void setdepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId + ", departmantName=" + departmantName
                + ", departmentAddress="
                + departmentAddress + ", departmentCode=" + departmentCode + "]";
    }

}