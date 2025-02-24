package com.techzen.academy_n1224.controller;

import com.techzen.academy_n1224.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n1224.model.Employee;
import com.techzen.academy_n1224.dto.ApiRespone;
import com.techzen.academy_n1224.exception.ApiException;
import com.techzen.academy_n1224.exception.ErrorCode;
import com.techzen.academy_n1224.service.IEmployeeService;
import com.techzen.academy_n1224.until.JsonRespone;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmployeeController {
    IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAll(EmployeeSearchRequest employeeSearchRequest) {
        return JsonRespone.ok(employeeService.findByAttributes(employeeSearchRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiRespone<Employee>> getEmployee(@PathVariable("id") UUID id) {
        return employeeService.findById(id)
                .map(JsonRespone::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));
    }

    @PostMapping("/employee/add")
    public ResponseEntity<?> create(@RequestBody Employee employees) {
        return JsonRespone.created(employeeService.save(employees));
    }

    @PutMapping("/employee/upd/id={id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody Employee employees) {
        employeeService.findById(id).orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));

        employees.setId(id);
        return JsonRespone.ok(employeeService.save(employees));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        employeeService.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));

        employeeService.delete(id);
        return JsonRespone.noContent();
    }
}