package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student semih = new Student(
                    "Semih Özer",
                    LocalDate.of(2004,Month.JANUARY,20),
                    "semihozer@gmail.com"
            );

            Student yunus = new Student(
                    "Yunus Özyavuz",
                    LocalDate.of(1978,Month.AUGUST,17),
                    "sagopakajmer@gmail.com"
            );
            repository.saveAll(
                    List.of(semih,yunus)
            );
        };
    }

}
