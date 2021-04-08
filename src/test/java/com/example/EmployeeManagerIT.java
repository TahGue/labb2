package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerIT {

    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
   BankService bankService = new TestBankService();
   EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);


    @BeforeEach
    void setUp() {
    employeeRepository.employees.add(new Employee("Gustav", 25000.0));
    employeeRepository.employees.add(new Employee("Jessica", 25000.0));
    employeeRepository.employees.add(new Employee("Tahar", 25000.0));

    }
    @Test
    @DisplayName("testa payEmployees inMemory")
    void testInMemoryPayEmployees(){
    var expected = employeeManager.payEmployees();
        assertEquals(expected, 3);

    }
    @Test
    @DisplayName(" test save method ")
    void testSavemethod(){
        employeeRepository.save(new Employee("Farrukh", 25000.0));

        var expected = employeeManager.payEmployees();

        assertEquals(expected, 4);


    }
}