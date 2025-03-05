package com.techzen.academy_n1224.model;

import com.techzen.academy_n1224.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;
    String name;
    LocalDate dob;
    @Column(columnDefinition = "enum ( 'male','female')")
    @Enumerated(EnumType.STRING)
    Gender gender;
    BigDecimal salary;
    String phone;
    @ManyToOne(fetch = FetchType.EAGER)
    Department department;

}