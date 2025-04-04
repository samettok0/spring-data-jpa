package com.samettok.controller;

import com.samettok.dto.DtoStudent;
import com.samettok.dto.DtoStudentIU;

import java.util.List;

public interface IStudentController  {
    public DtoStudent saveStudent(DtoStudentIU dtoStudent);

    public DtoStudent getStudentById(int id);

    public List<DtoStudent> getAllStudents();

    public void deleteStudentById(int id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU updatedStudent);
}
