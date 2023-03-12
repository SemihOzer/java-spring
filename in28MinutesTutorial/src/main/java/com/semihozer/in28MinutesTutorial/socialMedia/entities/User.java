package com.semihozer.in28MinutesTutorial.socialMedia.entities;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    @Size(min = 2, message = "Size of name should be at least 2 char")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDate date;

}
