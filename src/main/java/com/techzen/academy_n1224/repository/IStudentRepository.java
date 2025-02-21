package com.techzen.academy_n1224.repository;

import com.techzen.academy_n1224.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findByName(String name);

    Student findById(int id);

    Student save(Student student);
}
