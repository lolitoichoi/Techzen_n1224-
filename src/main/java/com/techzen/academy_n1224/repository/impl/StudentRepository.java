package com.techzen.academy_n1224.repository.impl;

import com.techzen.academy_n1224.Student;
import com.techzen.academy_n1224.repository.IStudentRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
@Scope("prototype")
public class StudentRepository implements IStudentRepository {
    private final List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Tuan", 9.0),
                    new Student(2, "Mai", 8.0),
                    new Student(3, "Hưng", 9.0)
            )
    );

    public List<Student> findByName(String name) {
        List<Student> studentSreach = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().contains(name)) {
                studentSreach.add(student);
            }
        }
        return studentSreach;
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student save(Student student) {
        for (Student stud : students) {
            if (stud.getId() == student.getId()) {
                stud.setName(student.getName());
                stud.setScore(student.getScore());
                return stud;
            }
        }
        student.setId((int) (Math.random() * 10000));
        students.add(student);
        return student;
    }
}
