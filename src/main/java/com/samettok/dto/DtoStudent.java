// DTO class for GET request
package com.samettok.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {
    private String firstName;
    private String lastName;
    private String email;
}
