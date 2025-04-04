package com.samettok.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "first_name", length = 50)
    private String firstName;
    @Column(nullable = false, name =  "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(nullable = false, name = "date_of_birth")
    private Date dateOfBirth;
    
}
