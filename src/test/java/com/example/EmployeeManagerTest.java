package com.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {


    @Test
    @DisplayName("Test1")
void testEmployeeRepository(){
  EmployeeRepository employeeRepository = new TestEmployeeRepository();

    employeeRepository.findAll();
    var actual = employeeRepository.findAll();
   var employees   = actual.stream()
           .filter(employee -> employee.getId().equals("Gustav"))
           .map((employeeId)->employeeId.getId())
           .collect(Collectors.toList());
            assertThat(employees).containsExactly(new Employee("Gustav", 25000).getId());
    }
    @Test
    @DisplayName("Mocking test")
    void testMocking(){
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    when(employeeRepository.findAll()).thenReturn(List.of(new Employee( "Gustav", 25000),
            new Employee("Jessica", 25000),
            new Employee("Tahar", 25000)));
        var actual = employeeRepository.findAll();
        actual.get(0).setId("Gusta");
        var employees   = actual.stream()
                .filter(employee -> employee.getId().equals("Gusta"))
                .map((employeeId)->employeeId.getId())
                .collect(Collectors.toList());
        assertThat(employees).containsExactly(new Employee("Gusta", 25000).getId());
    }
    @Test
    void testSalary() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000),
                new Employee("Jessica", 25000),
                new Employee("Tahar", 25000)));
        var actual = employeeRepository.findAll();
        actual.get(0).setSalary(15000);
        var employees = actual.stream()
                .filter(employee -> employee.getId().equals("Gustav"))
                .map((employeeId) -> employeeId.getSalary())
                .collect(Collectors.toList());
               assertThat(employees).containsExactly(new Employee("Gustav", 15000).getSalary());
    }
    @Test
    void testISemployeepayed(){
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee( "Gustav", 25000),
                new Employee("Jessica", 25000),
                new Employee("Tahar", 25000)));
        var actual = employeeRepository.findAll();
        actual.get(0).setPaid(true);

        assertTrue(actual.get(0).isPaid());
    }
    @Test
    void testToString(){
        Employee employee = new Employee("Martin", 25000.0);
        String expected = "Employee [id=Martin, salary=25000.0]";
        assertEquals(expected, employee.toString());
    }
    @Test
    void testpayment() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000),
                new Employee("Jessica", 25000),
                new Employee("Tahar", 25000)));
        BankService bankService = new TestBankService();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);
        var expected = employeeManager.payEmployees();
        assertEquals(expected, 3);
    }
        @Test
        void testTrayCatch() {
            EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
            when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000),
                    new Employee("Jessica", 25000),
                    new Employee("Martin", 25000),
                    new Employee("Tahar", 25000)));

            BankService bankService = new TestBankService();
            EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);
            var expected = employeeManager.payEmployees();
            assertEquals(expected, 3);
        }

    }

