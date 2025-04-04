package com.samettok.repository;

import com.samettok.entities.Student;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> { // Entity class adı ve primary key in variable type'ını yaz

    @Query(value = "from Student", nativeQuery = false) //JPQL (nativeQuery = false), Native SQL (nativeQuery = true)
    List<Student> findAllStudents();
    
    // JPQL ile isim parametresine göre öğrenci bulma
    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName")
    List<Student> findStudentsByFirstName(@Param("firstName") String firstName);
    
    // JPQL ile email içeren öğrencileri bulma
    @Query("SELECT s FROM Student s WHERE s.email LIKE CONCAT('%', :keyword, '%')")
    List<Student> findStudentsByEmailContaining(@Param("keyword") String keyword);
    
    // Native SQL ile ID aralığındaki öğrencileri bulma
    @Query(value = "SELECT * FROM student WHERE id BETWEEN :start AND :end", nativeQuery = true)
    List<Student> findStudentsByIdRange(@Param("start") Integer start, @Param("end") Integer end);
    
    // JPQL ile öğrencileri soyadına göre sıralama
    @Query("SELECT s FROM Student s ORDER BY s.lastName ASC")
    List<Student> findAllStudentsOrderByLastName();
    
    // JPQL ile birden fazla koşulla öğrenci bulma
    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName AND s.lastName = :lastName")
    List<Student> findStudentsByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
    
    // Native SQL ile öğrenci sayısını getirme
    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Long countStudents();
    
    // Belirli bir tarihten sonra doğan öğrencileri bulma
    @Query("SELECT s FROM Student s WHERE s.dateOfBirth > :date")
    List<Student> findStudentsBornAfter(@Param("date") Date date);
    
    // JPQL ile birden çok alan seçme (projection)
    @Query("SELECT s.id, s.firstName, s.lastName FROM Student s")
    List<Object[]> findStudentNamesAndIds();
    
    // Native SQL ile öğrencileri email uzantısına göre filtreleme
    @Query(value = "SELECT * FROM student WHERE email LIKE CONCAT('%', :domain)", nativeQuery = true)
    List<Student> findStudentsByEmailDomain(@Param("domain") String domain);
}
