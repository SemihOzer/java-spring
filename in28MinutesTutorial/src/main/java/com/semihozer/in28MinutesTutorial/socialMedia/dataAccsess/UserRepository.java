package com.semihozer.in28MinutesTutorial.socialMedia.dataAccsess;

import com.semihozer.in28MinutesTutorial.socialMedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
