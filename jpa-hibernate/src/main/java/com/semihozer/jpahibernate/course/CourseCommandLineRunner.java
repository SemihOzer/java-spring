package com.semihozer.jpahibernate.course;

import com.semihozer.jpahibernate.course.jdbc.Course;
import com.semihozer.jpahibernate.course.jdbc.CourseJdbcRepository;
import com.semihozer.jpahibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository jdbcRepository;

    @Autowired
    private CourseJpaRepository jpaRepository;

    @Autowired
    private CourseSpringJpaRepository springJpaRepository;

    Course course = new Course(1,"AWS","Semih");
    Course course2 = new Course(2,"Backend","Semih");
    Course course3 = new Course(3,"Mobile","Semih");
    Course course4 = new Course(4,"Machine Learning","Semih");
    Course course5 = new Course(5,"Data Science","Semih");
    Course course6 = new Course(6,"NLP","Semih");

    @Override
    public void run(String... args) throws Exception {
        jdbcRepository.insert(course);
        jdbcRepository.insert(course2);

        jpaRepository.insert(course3);
        jpaRepository.insert(course4);

        jpaRepository.deleteById(3);

        jdbcRepository.deleteById(1);

        springJpaRepository.save(course5);
        springJpaRepository.save(course6);

        springJpaRepository.deleteById(5L);




        System.out.println(jdbcRepository.findById(2).toString());
        System.out.println(jpaRepository.findById(4).toString());
        System.out.println(springJpaRepository.findById(6L));
        System.out.println(springJpaRepository.findByName("Backend"));
    }
}
