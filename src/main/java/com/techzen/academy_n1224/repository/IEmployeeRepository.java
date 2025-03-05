package com.techzen.academy_n1224.repository;

import com.techzen.academy_n1224.Gender;
import com.techzen.academy_n1224.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n1224.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query(value = """
                        from Employee e left join Department d on e.department_id = d.id 
                        where (:name is null or e.name like concat('%', :name,'%'))
                        and (:dobFrom is null or e.dob >= :dobFrom)
                        and (:dobTo is null or e.dob <= :dobTo)
                        and (:gender is null or e.gender = :gender)
                        and (:phone is null or e.phone like concat('%', :phone,'%'))
                        and (:departmentId is null or d.id = :departmentId)      
                        and (
                        case
                            when :salary = 'lt5' then e.salary < 5000000
                            when :salary = '5-10' then e.salary between 5000000 and 10000000
                            when :salary = '10-20' then e.salary between 10000000 and 20000000
                            when :salary = 'gt20' then e.salary > 20000000
                            else true
                            end 
                        )      
            """, nativeQuery = true)
    List<Employee> findByAttributes(@Param("name") String name,
                                    @Param("dobFrom") LocalDate dobFrom,
                                            @Param("dobTo") LocalDate dobTo,
                                            @Param("gender") Gender gender,
                                            @Param("salary") String salary,
                                            @Param("phone") String phone,
                                            @Param("departmentId") Integer departmentId);


    Optional<Employee> findById(UUID id);

    Employee save(Employee employees);

    void delete(UUID id);


}
