package com.techzen.academy_n1224.controller;

import com.techzen.academy_n1224.service.IStudentService;
import com.techzen.academy_n1224.model.Student;
import com.techzen.academy_n1224.dto.ApiRespone;
import com.techzen.academy_n1224.exception.ApiException;
import com.techzen.academy_n1224.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Scope("singleton")
public class StudentController {
   // TIÊM Theo thuộc tính,tiêm theo constructor,tiêm theo setter
    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents(@RequestParam(defaultValue = "") String name, Double fromScore, Double toScore) {
        return ResponseEntity.ok(ApiRespone.builder().data(studentService.findByName(name,fromScore,toScore)).build());
    }

    // @RequestMapping("/student")
    @GetMapping("/{id}")
    public ResponseEntity<ApiRespone<Student>> getById(@PathVariable("id") int id,Double fromScore, Double toScore) {
        Student student = studentService.findById(id);
        if (student == null) {
            throw new ApiException(ErrorCode.STUDENT_NOT_EXIT);
        }
        return ResponseEntity.ok(ApiRespone.<Student>builder().data(student).build());
    }

    @PostMapping  // thêm
    public ResponseEntity<ApiRespone<Student>> save(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiRespone.<Student>builder()
                .data(studentService.save(student))
                .build());

    }

    @PutMapping("/{id}") // update
    public ResponseEntity<ApiRespone<Student>> update(@PathVariable int id, @RequestBody Student student) {

        student.setId(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiRespone.<Student>builder()
                .data(studentService.save(student))
                .build());
    }
}
