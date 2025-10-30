package com.salary.employeeapi.controller;

import com.salary.employeeapi.controller.EmployeeController;
import com.salary.employeeapi.model.Employee;
import com.salary.employeeapi.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    EmployeeService service = mock(EmployeeService.class);
    EmployeeController controller = new EmployeeController(service);

    @Test
    public void testCreateEmployee() {
        Employee e = new Employee();
        e.setFullName("John Doe");
        e.setSalary(1000);
        when(service.createEmployee(e)).thenReturn(e);

        Employee created = controller.create(e);
        assertEquals("John Doe", created.getFullName());
    }

    @Test
    public void testNetSalaryIndia() {
        Employee e = new Employee();
        e.setCountry("India");
        e.setSalary(1000);
        when(service.getEmployee(1L)).thenReturn(Optional.of(e));

        double net = controller.netSalary(1L);
        assertEquals(900, net);
    }
}
