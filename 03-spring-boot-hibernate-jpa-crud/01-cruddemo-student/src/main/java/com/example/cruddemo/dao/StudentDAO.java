package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save (Student theStudent);

    Student findById(int theId);

    List<Student> findAll();

    List<Student> findByLastName(String theName);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll();
}
