package uk.ac.hope.mcse.segh.servermanagement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("John", "Doe", 50, "Bottle Washer");
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", employee.getFirstName());
    }


}