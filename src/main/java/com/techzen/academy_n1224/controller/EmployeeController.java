package com.techzen.academy_n1224.controller;

import com.techzen.academy_n1224.Gender;
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
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmployeeController {
    IEmployeeService employeeService;
   // nâng cấp api theo mô hình mvc
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








    // tạo api resful
    private final List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Van Tuan", LocalDate.of(2000, 1, 13),
                            Gender.Male, 18888.00, "99091908283", 12),
                    new Employee(UUID.randomUUID(), "Van Tu", LocalDate.of(2000, 1, 13),
                            Gender.Female, 18888.00, "99091908283", 12)
            )
    );
//
//    @GetMapping
//    public ResponseEntity<List<Employee>> getAll() {
//        return ResponseEntity.ok(employees);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity <Employee> getEmployeeById(@PathVariable("id") UUID id) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//    @PostMapping("/{id}")
//    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
//        employee.setId(UUID.randomUUID());
//        employees.add(employee);
//        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> update(@PathVariable("id") UUID id, @RequestBody Employee employee) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(e -> {
//                    e.setName(employee.getName());
//                    e.setGender(employee.getGender());
//                    e.setDob(employee.getDob());
//                    e.setSalary(employee.getSalary());
//                    e.setPhone(employee.getPhone());
//                    e.setDepartmentId(employee.getDepartmentId());
//
//                    return ResponseEntity.ok(e);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete (@PathVariable("id") UUID id) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(s -> {
//                    employees.remove(s);
//                    return ResponseEntity.ok().build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }


    // sử dụng lombok
    // cải tiến xử lí lỗi

//    @GetMapping
//    public ResponseEntity<?> getAll() {
//        return JsonRespone.ok(employees);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity <?> getEmployeeById(@PathVariable("id") UUID id) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(ResponseEntity::ok)
//                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));
//    }
//    @PostMapping("/{id}")
//    public ResponseEntity<?> create(@RequestBody Employee employee) {
//        employee.setId(UUID.randomUUID());
//        employees.add(employee);
//        return JsonRespone.created(employee);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody Employee employee) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(e -> {
//                    e.setName(employee.getName());
//                    e.setGender(employee.getGender());
//                    e.setDob(employee.getDob());
//                    e.setSalary(employee.getSalary());
//                    e.setPhone(employee.getPhone());
//                    e.setDepartmentId(employee.getDepartmentId());
//
//                    return JsonRespone.ok(e);
//                })
//                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete (@PathVariable("id") UUID id) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(s -> {
//                    employees.remove(s);
//                    return JsonRespone.noContent();
//                })
//                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));
//    }


    // cải tiến thêm chức năng timf kiếm và xây dựng thêm
//    @GetMapping
//    public ResponseEntity<?> getAll(
//            @RequestParam(value = "name ", required = false) String name,
//            @RequestParam(value = "dobFrom ", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobFrom,
//            @RequestParam(value = "dobTo ", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobTo,
//            @RequestParam(value = "gender ", required = false) Gender gender,
//            @RequestParam(value = "salaryRange ", required = false) String salaryRange,
//            @RequestParam(value = "phone ", required = false) String phone,
//            @RequestParam(value = "departmentId ", required = false) Integer departmentId
//    ) {
//        List<Employee> filteredEmployees = employees.stream()
//                .filter(e -> (name == null || e.getName().toLowerCase().contains(name.toLowerCase())))
//                .filter(e -> (dobFrom == null || !e.getDob().isBefore(dobFrom)))
//                        .filter(e -> (dobTo == null || !e.getDob().isAfter(dobTo)))
//                .filter(e -> (gender == null || e.getGender() == gender))
//                .filter(e -> (phone == null || e.getPhone().contains(phone)))
//                .filter(e -> (departmentId == null || Objects.equals(e.getDepartmentId(),departmentId)))
//                .filter( e -> {
//                    if(salaryRange == null ) {
//                        return true;
//                    }
//                    return switch (salaryRange) {
//                        case "lt5" -> e.getSalary() < 50000;
//                        case "1000" -> e.getSalary() < 10000;
//                        case "2000" -> e.getSalary() < 20000;
//                        default -> true;
//                    };
//                })
//                .collect(Collectors.toList());
//        return JsonRespone.ok(filteredEmployees);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getEmployeeById(@PathVariable("id") UUID id) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(ResponseEntity::ok)
//                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));
//    }
//
//    @PostMapping("/{id}")
//    public ResponseEntity<?> create(@RequestBody Employee employee) {
//        employee.setId(UUID.randomUUID());
//        employees.add(employee);
//        return JsonRespone.created(employee);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody Employee employee) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(e -> {
//                    e.setName(employee.getName());
//                    e.setGender(employee.getGender());
//                    e.setDob(employee.getDob());
//                    e.setSalary(employee.getSalary());
//                    e.setPhone(employee.getPhone());
//                    e.setDepartmentId(employee.getDepartmentId());
//
//                    return JsonRespone.ok(e);
//                })
//                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(s -> {
//                    employees.remove(s);
//                    return JsonRespone.noContent();
//                })
//                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIT));
//    }

}



