package com.semihozer.retimy.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


//TODO
//balance double default 0
//relationship table

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name",nullable = false)
    @Min(2)
    @Max(15)
    private String name;

    @Column(name = "surname",nullable = false)
    @Min(2)
    @Max(15)
    private String surname;

    @Column(name = "birthDate",nullable = false)
    @Past
    private LocalDate birthDate;

    @Column(name = "balance")
    @Min(0)
    private double balance;

    @Column(name = "personalInformation")
    @Min(100)
    @Max(400)
    private String personalInformation;

    @OneToOne(mappedBy = "fromUser")
    private Post posts;

    @OneToMany(mappedBy = "fromUser")
    private List<Post> activePosts;

    @OneToMany(mappedBy = "fromUser")
    private List<Post> pastPosts;
}
