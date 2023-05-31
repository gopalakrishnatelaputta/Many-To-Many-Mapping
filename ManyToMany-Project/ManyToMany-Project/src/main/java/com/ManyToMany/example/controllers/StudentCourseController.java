package com.ManyToMany.example.controllers;

import com.ManyToMany.example.entities.Course;
import com.ManyToMany.example.entities.Student;
import com.ManyToMany.example.repository.CourseRepository;
import com.ManyToMany.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController
{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    @PostMapping("/saveStudent")
    public Student saveStudentWithCourse(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }
    @GetMapping("/getAllStudents")
    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }
    @GetMapping("/getById/{studentId}")
    public Student findStudentById(@PathVariable Long studentId)
    {
        return studentRepository.findById(studentId).orElseThrow(null);
    }
    @GetMapping("findByName/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name)
    {
        return studentRepository.findByNameContaining(name);
    }
    @GetMapping("search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price)
    {
       return courseRepository.findByFeeLessThan(price);
    }

}
