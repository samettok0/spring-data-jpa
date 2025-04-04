package com.samettok.controller;

import com.samettok.controller.impl.StudentControllerImpl;
import com.samettok.entities.Student;

import java.util.List;

public interface IStudentController  {
    public Student saveStudent(Student student);

    public Student getStudentById(int id);

    public List<Student> getAllStudents();

    public void deleteStudentById(int id);

    public Student updateStudent(Integer id, Student updatedStudent);
}
