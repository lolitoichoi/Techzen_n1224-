package com.techzen.academy_n1224.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(columnDefinition = "varchar(50)")
    String name;


}
