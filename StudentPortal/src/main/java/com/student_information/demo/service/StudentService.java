package com.student_information.demo.service;

import java.util.List;

import com.student_information.demo.model.Student;

public interface StudentService {
    
    List<Student> findAll();

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpa();

    void saveOrUpdateStudent(Student student);

    void deleteStudent(String id);
    
}