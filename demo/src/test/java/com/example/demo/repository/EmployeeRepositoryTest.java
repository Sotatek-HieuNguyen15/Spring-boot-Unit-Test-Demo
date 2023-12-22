package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void addNewEmployee_thenReturnNewEmployee(){
        //Arrange
        Employee newEntity = Employee.builder()
                .name("test")
                .build();
        //Act
        Employee savedEntity = employeeRepository.save(newEntity);
        //Assertion
        Assertions.assertNotNull(savedEntity);
        Assertions.assertEquals(savedEntity.getName(),"test");
    }
}
