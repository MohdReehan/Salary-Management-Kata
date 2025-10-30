Employee API 

Overview

This project is a RESTful API for managing employee data, calculating net salaries, and providing salary metrics.

It is implemented in Java (Spring Boot) with SQLite as the database. The project follows Test-Driven Development (TDD) and is production-ready.


Features

1. Employee CRUD

-> Create: Add a new employee

-> Read: Get employee by ID / Get all employees

-> Update: Update employee details

-> Delete: Remove employee


Fields stored for each employee:

-> full_name (String)

-> job_title (String)

-> country (String)

-> salary (double)


2. Salary Calculation

-> Endpoint: /employees/salary/{id}

-> Calculates net salary based on TDS deduction rules:

     -> India: 10% of gross

	 -> United States: 12% of gross

	 -> Others: no deduction

3. Salary Metrics

   -> By country: minimum, maximum, and average salary

   -> By job title: average salary
   
   




Endpoints
Endpoint	Method	Description
/employees	POST	Create employee
/employees/{id}	GET	Get employee by ID
/employees	GET	Get all employees
/employees/{id}	PUT	Update employee
/employees/{id}	DELETE	Delete employee
/employees/salary/{id}	GET	Calculate net salary
/employees/metrics/country/{country}	GET	Min, max, avg salary by country
/employees/metrics/job/{jobTitle}	GET	Average salary by job title




TDD Workflow

All features were implemented using Test-Driven Development (TDD):

Write failing unit tests for the functionality (Red)

Implement minimal code to pass tests (Green)

Refactor code for clarity and maintainability (Refactor)

Commit after each loop to show evolution

Tests were written using JUnit and Mockito and cover:

CRUD operations for employee resource

Salary calculation logic

Salary metrics endpoints and edge cases
