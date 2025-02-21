package com.techzen.academy_n1224.service;

import com.techzen.academy_n1224.IStudentService;
import com.techzen.academy_n1224.Student;
import com.techzen.academy_n1224.exception.ApiException;
import com.techzen.academy_n1224.repository.IStudentRepository;
import com.techzen.academy_n1224.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
@Service
@Scope("singleton")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    private IStudentRepository studentRepository;

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
