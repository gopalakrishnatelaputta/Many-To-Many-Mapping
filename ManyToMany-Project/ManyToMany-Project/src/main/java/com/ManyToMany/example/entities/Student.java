package com.ManyToMany.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="STUDENT_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private String dept;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TABLE",

            joinColumns={@JoinColumn(name = "student_id",referencedColumnName = "id"),
    },
            inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "id")}

    )
    private Set<Course> courses;

}
