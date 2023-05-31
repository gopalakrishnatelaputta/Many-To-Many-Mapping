package com.ManyToMany.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name ="COURSE_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course
{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String abbreviation;
    private  int module;
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private Set<Student> students;




}
