package com.babydevcode.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dni")
    private Long dni;

    @Column(name = "student_status")
    private Short studentStatus;

    @Column(name = "student_career")
    private Short studentCareer;
}
