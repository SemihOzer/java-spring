package com.semihozer.in28MinutesTutorial.socialMedia.dataAccsess;

import com.semihozer.in28MinutesTutorial.socialMedia.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
