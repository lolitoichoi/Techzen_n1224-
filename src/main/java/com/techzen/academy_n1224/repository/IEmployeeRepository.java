package com.techzen.academy_n1224.repository;

import com.techzen.academy_n1224.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n1224.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository {
    List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest);

    Optional<Employee> findById(UUID id);

    Employee save(Employee employees);

    void delete(UUID id);

}
