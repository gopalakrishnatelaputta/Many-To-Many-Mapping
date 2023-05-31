package com.ManyToMany.example.repository;

import com.ManyToMany.example.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

        List<Course> findByFeeLessThan(double fee);
}
