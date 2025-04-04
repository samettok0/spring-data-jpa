package com.samettok.services;

import com.samettok.dto.DtoStudent;
import com.samettok.dto.DtoStudentIU;
import com.samettok.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU dtoStudent);
    public DtoStudent getStudentById(int id);
    public List<DtoStudent> getAllStudents();
    public void deleteStudentById(int id);
    public DtoStudent updateStudent(Integer id, DtoStudentIU updatedStudent);
}
