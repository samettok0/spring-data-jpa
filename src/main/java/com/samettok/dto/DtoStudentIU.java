//DtoStudent might include all fields needed for displaying student data
//DtoStudentIU might only include fields that can be modified during creation or updates
//DtoStudentIU might have validation annotations specific to create/update operations
package com.samettok.dto;

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
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;

}
