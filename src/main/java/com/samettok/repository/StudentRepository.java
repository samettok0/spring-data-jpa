package com.samettok.repository;

import com.samettok.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> { // Entity class adı ve primary key in variable type'ını yaz
    
}
