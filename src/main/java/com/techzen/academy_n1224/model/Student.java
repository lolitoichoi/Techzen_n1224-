package com.techzen.academy_n1224.model;


import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(50)")
     String name;
     double score;

    @ManyToOne
    Clazz clazz;
}
