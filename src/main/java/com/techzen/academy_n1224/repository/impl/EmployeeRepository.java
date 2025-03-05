package com.techzen.academy_n1224.repository.impl;

import com.techzen.academy_n1224.Gender;
import com.techzen.academy_n1224.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n1224.model.Employee;
import com.techzen.academy_n1224.repository.IEmployeeRepository;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class EmployeeRepository implements IEmployeeRepository {

    @Override
    public List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest) {

        Session session = ConnectionUtil.sessionFactory.openSession();

        String hql = "from Employee e left join fetch e.department where "
                + "(:name is null or lower(e.name) like concat('%', :name, '%')) "
                + "and (:dobFrom is null or e.dob >= :dobFrom) "
                + "and (:dobTo is null or e.dob <= :dobTo)"
                + "and (:gender is null or e.gender = :gender)"
                + "and (:phone is null or e.phone like concat('%', :phone, '%'))"
                + "and (:departments is null or e.department = :departmentId)";


        if (employeeSearchRequest.getSalary() != null) {
            hql += "and (*";
            switch (employeeSearchRequest.getSalary()) {
                case "lt5":
                    hql += "e.salary < 5000000 ";
                    break;
                case "5-10":
                    hql += "e.salary >= 5000000 and e.salary < 10000000 ";
                    break;
                case "10-20":
                    hql += "e.salary >= 10000000 and e.salary <= 20000000 ";
                    break;
                case "gt20":
                    hql += "e.salary > 20000000 ";
                    break;
            }
            hql += ")";
        }
        Query<Employee> query = session.createQuery(hql, Employee.class);

        query.setParameter("name", employeeSearchRequest.getName());
        query.setParameter("dobFrom", employeeSearchRequest.getDobFrom());
        query.setParameter("dobTo", employeeSearchRequest.getDobTo());
        query.setParameter("gender", employeeSearchRequest.getGender());
        query.setParameter("phone", employeeSearchRequest.getPhone());
        query.setParameter("department", employeeSearchRequest.getDepartmentId());
        return query.getResultList();
    }

}
