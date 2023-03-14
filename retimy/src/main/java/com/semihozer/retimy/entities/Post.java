package com.semihozer.retimy.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Join;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;

    @Column(name = "price",nullable = false)
    @Min(0)
    private int price;

    @Column(name = "title",nullable = false)
    @Min(5)
    @Max(20)
    private String title;

    @Column(name = "text",nullable = false)
    @Min(50)
    @Max(800)
    private String text;

    @Column(name = "status",nullable = false)
    @Min(0)
    @Max(2)
    private int status; // 0-> penidng 1-> accepted 2-> completed


    @Column(name = "timestamp")
    @PastOrPresent
    private LocalDateTime timestamp;

    @Column(name = "deliveryDate")
    @FutureOrPresent
    private LocalDate deliveryDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User fromUser;

    





}
