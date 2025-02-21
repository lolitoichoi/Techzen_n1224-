package com.techzen.academy_n1224;

import java.util.List;

public interface IStudentService {
     List<Student> findByName(String name);

     Student findById(int id) ;

     Student save(Student student) ;
}
