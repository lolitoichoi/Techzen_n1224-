package com.techzen.academy_n1224.repository;

import com.techzen.academy_n1224.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    //    List<Student> findByNameContainingAndScoreBetween(String name,double fromScore,double toScore);
    @Query("""
            FROM Student where name like concat('%', :name, '%') 
            and (:fromScore is null or score >= :fromScore) 
            and (:toScore is null or score <= :toScore) 
            """)
    List<Student> findAtribute(@Param("name") String name,
                               @Param("fromScore")  Double fromScore,
                               @Param("toScore")  Double toScore);

    Student findById(int id);

}
