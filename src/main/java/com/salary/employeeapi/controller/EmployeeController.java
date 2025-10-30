package com.salary.employeeapi.controller;


import com.salary.employeeapi.model.Employee;
import com.salary.employeeapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee create(@RequestBody Employee e) {
        return service.createEmployee(e);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return service.getEmployee(id).orElseThrow();
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee e) {
        return service.updateEmployee(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployee(id);
    }

    @GetMapping("/salary/{id}")
    public double netSalary(@PathVariable Long id) {
        Employee e = service.getEmployee(id).orElseThrow();
        return service.calculateNetSalary(e);
    }

    @GetMapping("/metrics/country/{country}")
    public double[] metricsByCountry(@PathVariable String country) {
        return service.salaryMetricsByCountry(country);
    }

    @GetMapping("/metrics/job/{jobTitle}")
    public double avgByJob(@PathVariable String jobTitle) {
        return service.averageSalaryByJobTitle(jobTitle);
    }
}
