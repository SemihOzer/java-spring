package com.semihozer.in28MinutesTutorial.socialMedia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, message = "Size of name should be at least 2 char")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDate date;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
