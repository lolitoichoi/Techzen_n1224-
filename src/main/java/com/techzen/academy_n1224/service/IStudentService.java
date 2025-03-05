package com.techzen.academy_n1224.service;

import com.techzen.academy_n1224.model.Student;

import java.util.List;

public interface IStudentService {
     List<Student> findByName(String name,Double fromScore, Double toScore);

     Student findById(int id) ;

     Student save(Student student) ;
}
