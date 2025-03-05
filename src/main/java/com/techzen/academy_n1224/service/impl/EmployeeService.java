package com.techzen.academy_n1224.service.impl;

import com.techzen.academy_n1224.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n1224.model.Employee;
import com.techzen.academy_n1224.repository.IEmployeeRepository;
import com.techzen.academy_n1224.service.IEmployeeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest) {
      return employeeRepository.findByAttributes(employeeSearchRequest.getName(),
              employeeSearchRequest.getDobFrom(),
              employeeSearchRequest.getDobTo(),
              employeeSearchRequest.getSalary(),
              employeeSearchRequest.getGender(),
              employeeSearchRequest.getPhone(),
              employeeSearchRequest.getDepartmentId()
              );
    }
    @Override
    public Optional <Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employees) {
        return employeeRepository.save(employees);
    }

    @Override
    public void delete(UUID id) {
        employeeRepository.delete(id);
    }
}
