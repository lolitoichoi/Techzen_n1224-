package com.techzen.academy_n1224.repository.impl;

import com.techzen.academy_n1224.Gender;
import com.techzen.academy_n1224.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n1224.model.Employee;
import com.techzen.academy_n1224.repository.IEmployeeRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class EmployeeRepository implements IEmployeeRepository {
    List<Employee> employee = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Nguễn Văn Tuấn", LocalDate.of(2003, 6, 13), Gender.Male, 1200000.00, "071212312", 20),
                    new Employee(UUID.randomUUID(), "Nguễn Văn TÚ", LocalDate.of(2008, 10, 10), Gender.Male, 1200000.00, "071212312", 15),
                    new Employee(UUID.randomUUID(), "Nguễn Văn Hưng", LocalDate.of(20011, 11, 2), Gender.Male, 1200000.00, "071312312", 05),
                    new Employee(UUID.randomUUID(), "Nguễn Văn Thịnh", LocalDate.of(2019, 9, 19), Gender.Male, 1200000.00, "071312312", 10),
                    new Employee(UUID.randomUUID(), "Đỗ Thị Thi Mai", LocalDate.of(2006, 8, 11), Gender.Female, 1200000.00, "012312312", 12)
            )
    );

    @Override
    public List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest) {
        return employee.stream()
                .filter(e -> (employeeSearchRequest.getName() == null
                        || employeeSearchRequest.getName().toLowerCase().contains(employeeSearchRequest.getName().toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return employee.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }
    @Override
    public Employee save(Employee employees) {
        return findById(employees.getId())
                .map(e -> {
                    e.setName(employees.getName());
                    e.setGender(employees.getGender());
                    e.setDob(employees.getDob());
                    e.setPhone(employees.getPhone());
                    e.setSalary(employees.getSalary());
                    e.setDepartmentId(employees.getDepartmentId());

                    return e;

                })
                .orElseGet(() -> {
                    employees.setId(UUID.randomUUID());
                    employee.add(employees);
                    return employees;
                });
    }

    @Override
    public void delete(UUID id) {
        findById(id).ifPresent(employee::remove);
    }
}
