package com.salary.employeeapi.service;


import com.salary.employeeapi.model.Employee;
import com.salary.employeeapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee createEmployee(Employee e) {
        return repo.save(e);
    }

    public Optional<Employee> getEmployee(Long id) {
        return repo.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee updateEmployee(Long id, Employee updated) {
        updated.setId(id);
        return repo.save(updated);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    // Salary calculation
    public double calculateNetSalary(Employee e) {
        double tds = 0.0;
        switch (e.getCountry().toLowerCase()) {
            case "india": tds = e.getSalary() * 0.10; break;
            case "united states": tds = e.getSalary() * 0.12; break;
        }
        return e.getSalary() - tds;
    }

    // Metrics
    public double averageSalaryByJobTitle(String jobTitle) {
        List<Employee> list = repo.findByJobTitle(jobTitle);
        return list.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public double[] salaryMetricsByCountry(String country) {
        List<Employee> list = repo.findByCountry(country);
        double min = list.stream().mapToDouble(Employee::getSalary).min().orElse(0.0);
        double max = list.stream().mapToDouble(Employee::getSalary).max().orElse(0.0);
        double avg = list.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        return new double[]{min, max, avg};
    }
}
