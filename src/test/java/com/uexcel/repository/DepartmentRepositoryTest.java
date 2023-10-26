package com.uexcel.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.uexcel.entity.Department;

// import jakarta.persistence.EntityManager;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    // @Autowired
    // private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmantName("EEC")
                .departmentAddress("Asaba")
                .departmentCode("EEC004")
                .build();
        departmentRepository.save(department);
    }

    @Test
    @Disabled
    public void dbTest() {
        Department found = departmentRepository.findById(1L).get();
        assertEquals(found.getDepartmantName(), "EEC");

    }
}
