package com.samettok.controller.impl;

import com.samettok.controller.IStudentController;
import com.samettok.dto.DtoStudent;
import com.samettok.dto.DtoStudentIU;
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
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudent) {
        return studentService.saveStudent(dtoStudent);
    }

    @GetMapping("/get/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/get/all")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    @DeleteMapping("/erase/{id}")
    public void deleteStudentById(@PathVariable(name = "id") int id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id")  Integer id,
                                 @RequestBody DtoStudentIU updatedStudent ) {
        return studentService.updateStudent(id, updatedStudent);
    }
}
