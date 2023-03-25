package com.semihozer.jpahibernate.course;

import com.semihozer.jpahibernate.course.jdbc.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);

}
