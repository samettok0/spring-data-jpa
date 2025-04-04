package com.samettok.services.impl;

import com.samettok.dto.DtoStudent;
import com.samettok.dto.DtoStudentIU;
import com.samettok.entities.Student;
import com.samettok.repository.StudentRepository;
import com.samettok.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository; // Katmanlar bağlandı (Repo -> Service)

    @Override
    // for IU operations we pass DtoStudentIU object and return a DtoStudent object
    public DtoStudent saveStudent(DtoStudentIU dtoStudent) {
        DtoStudent returnDto = new DtoStudent(); // this is we are going to return
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudent, student); // copy dtoStudent to student

        // Saves the student entity using studentRepository.save(student).
        // Returns the saved student entity with a newly assigned ID.
        Student dbStudent = studentRepository.save(student);

        //Copies properties from the saved entity (dbStudent) to the return DTO (returnDto).
        //This ensures the returned DTO contains the updated entity details, including the generated ID.
        BeanUtils.copyProperties(dbStudent, returnDto);

        return returnDto;
    }

    @Override
    public DtoStudent getStudentById(int id) {
        DtoStudent returnDto = new DtoStudent();
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            BeanUtils.copyProperties(student, returnDto);
            return returnDto;
        }
        return null;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List <DtoStudent> returnDto = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            returnDto.add(dtoStudent);
        }
        return returnDto;
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU updatedStudent) {
        Student dbStudent = studentRepository.findById(id).orElse(null);
        if (dbStudent != null) {
            dbStudent.setFirstName(updatedStudent.getFirstName());
            dbStudent.setLastName(updatedStudent.getLastName());
            dbStudent.setEmail(updatedStudent.getEmail());
            dbStudent.setDateOfBirth(updatedStudent.getDateOfBirth());

            Student upStudent = studentRepository.save(dbStudent);

            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(upStudent, dtoStudent);

            return dtoStudent;
        }
        return null;
    }
}
