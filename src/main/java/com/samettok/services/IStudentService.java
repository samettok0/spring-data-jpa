package com.samettok.services;

import com.samettok.entities.Student;

import java.util.List;

public interface IStudentService {
    public Student saveStudent(Student student);
    public Student getStudentById(int id);
    public List<Student> getAllStudents();
    public void deleteStudentById(int id);
    public Student updateStudent(Integer id, Student updatedStudent);
}
