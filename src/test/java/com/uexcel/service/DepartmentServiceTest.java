package com.uexcel.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.uexcel.entity.Department;
import com.uexcel.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    // @AfterAll
    // @AfterEach
    // The above 2 method are use to clear the data of the test case
    // @BeforeAll called only once for executing all the test cases

    @BeforeEach // for each and every test case added to the class
    void setUp() {

        Department department = Department.builder()
                .departmantName("ICT")
                .departmentAddress("Ikeja")
                .departmentCode("ICT004")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmantNameIgnoreCase("ICT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data By Valid Department Name")
    // @Disabled // to disable test case
    public void WhenDepartmentNameMatchThenDepartmentFound() {
        String departmentName = "ICT";
        Department found = departmentService.findDepartmantByName(departmentName);
        assertEquals(departmentName, found.getDepartmantName());
    }
}
