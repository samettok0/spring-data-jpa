package com.samettok.controller.impl;

import com.samettok.controller.IStudentController;
import com.samettok.entities.Student;
import com.samettok.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student") // Controller katmanında bu annotations kullanırız
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService; // Interface ile implemente edilir.
    // Katmanlar bağlandı (Service -> Controller)


    // DTO kullanılır normalde
    @PostMapping("/save")
    @Override
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/get/{id}")
    @Override
    public Student getStudentById(@PathVariable(name = "id") int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/get/all")
    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    @DeleteMapping("/erase/{id}")
    public void deleteStudentById(@PathVariable(name = "id") int id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Student updateStudent(@PathVariable(name = "id")  Integer id,
                                 @RequestBody Student updatedStudent ) {
        return studentService.updateStudent(id, updatedStudent);
    }
}
