package com.example.demo.service;


import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private EmployeeRepository employeeRepository;
    @Test
    public void addNewEmployee_ThenReturnNewEmployee(){
        //Arrange
        Employee newEmployee = Employee.builder().name("test").build();
        Mockito.when(employeeRepository.save(newEmployee)).thenReturn(newEmployee);
        //Act
        Employee addedEmployee = employeeService.addNew(newEmployee);
        //Assertion
        Assertions.assertEquals(addedEmployee,newEmployee);
    }
}
