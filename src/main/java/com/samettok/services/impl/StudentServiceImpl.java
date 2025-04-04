package com.samettok.services.impl;

import com.samettok.entities.Student;
import com.samettok.repository.StudentRepository;
import com.samettok.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository; // Katmanlar bağlandı (Repo -> Service)

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Integer id, Student updatedStudent) {
        Student dbStudent = getStudentById(id);
        if (dbStudent != null) {
            dbStudent.setFirstName(updatedStudent.getFirstName());
            dbStudent.setLastName(updatedStudent.getLastName());
            dbStudent.setEmail(updatedStudent.getEmail());
            dbStudent.setDateOfBirth(updatedStudent.getDateOfBirth());

            return studentRepository.save(dbStudent);
        }
        return null;
    }
}
