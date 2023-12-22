package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class EmployeeServiceWithSpringExtensionTest {
    @TestConfiguration
    public static class TestConfig {
        @Bean
        public EmployeeService employeeService(){
            return new EmployeeService();
        }
    }
    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;
    @Test
    public void addNewEmployee_ThenReturnNewEmployee(){
        Employee employee = Employee.builder().name("test").build();
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Employee employee1 = employeeService.addNew(employee);
        Assertions.assertEquals(employee1,employee);
    }
}
