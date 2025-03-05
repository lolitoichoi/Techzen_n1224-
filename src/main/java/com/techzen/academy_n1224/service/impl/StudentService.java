package com.techzen.academy_n1224.service.impl;

import com.techzen.academy_n1224.service.IStudentService;
import com.techzen.academy_n1224.model.Student;
import com.techzen.academy_n1224.repository.IStudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
@Service
@Scope("singleton")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    private IStudentRepository studentRepository;

    public List<Student> findByName(String name,Double fromScore, Double toScore) {
        return studentRepository.findAtribute(name,fromScore,toScore);
    }

    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
