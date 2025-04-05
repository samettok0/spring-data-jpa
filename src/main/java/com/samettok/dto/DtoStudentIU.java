//DtoStudent might include all fields needed for displaying student data
//DtoStudentIU might only include fields that can be modified during creation or updates
//DtoStudentIU might have validation annotations specific to create/update operations
package com.samettok.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Name cannot be empty or null.")
    @Size(min = 3, max = 20, message = "Enter min 3, max 20 characters for firstname.")
    private String firstName;

    @NotEmpty(message = "Lastname cannot be empty or null.")
    @Size(min = 3, max = 20, message = "Enter min 3, max 20 characters for lastname.")
    private String lastName;

    @NotEmpty(message = "E-mail cannot be empty or null.")
    @Email(message = "Please enter a valid e-mail.")
    private String email;

    @Past(message = "Date of birth must be in the past.")
    private Date dateOfBirth;

}
