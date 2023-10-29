package com.uexcel.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.uexcel.entity.Department;
import com.uexcel.repository.DepartmentRepository;
import com.uexcel.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @MockBean
    private MockMvc mockMvc;

    @MockBean
    DepartmentRepository departmentRepository;

    @MockBean
    DepartmentService departmentService;

    Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmantName("Human Resource")
                .departmentAddress("Ikoyi")
                .departmentCode("HR-07")
                .departmentId(1L)
                .build();

    }

    @Test
    void testGetDepartmentById() {
        Department inputDepartment = Department.builder()
                .departmantName("Human Resource")
                .departmentAddress("Ikoyi")
                .departmentCode("HR-07")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        // we can do static import for: MockMvcRequestBuilders, MockMvcResultMatchers

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/departments")

                    .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                            "\t\" departmentId\":+1L+\n" +
                            "\t\"departmantName\": \"Human Resource\",\n" +
                            "\t\"departmentAddress\":\"Ikoyi\",\n" +
                            "\t\"departmentCode\":\"HR-07\"}"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Test
    void testSaveDepartment() {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/departments/1L")

                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                            .value(department.getDepartmantName()));

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
