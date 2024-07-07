package uk.ac.hope.mcse.segh.servermanagement.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;



import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ServerManagementControllerTest {

    uk.ac.hope.mcse.segh.servermanagement.rest.ServerManagementController controller;

    @BeforeEach
    void setUp() {

        // Mock the service
        EmployeeDataServiceImpl employeeDataService = mock(EmployeeDataServiceImpl.class);
        Employee e = new Employee("John", "Doe", 50, "Waster");
        e.setId(1L);
        Optional<Employee> employee = Optional.of(e);
        when(employeeDataService.findEmployeeById(1L)).thenReturn(employee);

        controller = new uk.ac.hope.mcse.segh.servermanagement.EmployeeController(employeeDataService);
    }

    @Test
    void all() {
    }

    @Test
    void newEmployee() {
    }

    @Test
    void findById() {
        Employee employee = controller.findById(1L);
        assertEquals(employee.getAge(), 50);
    }

    @Test
    void replaceEmployee() {
    }

    @Test
    void deleteEmployee() {
    }
}