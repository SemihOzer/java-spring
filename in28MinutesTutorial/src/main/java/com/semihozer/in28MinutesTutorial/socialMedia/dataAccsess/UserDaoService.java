package com.semihozer.in28MinutesTutorial.socialMedia.dataAccsess;

import com.semihozer.in28MinutesTutorial.socialMedia.entities.User;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private static int usersCount = 0;

    static {
        users.add(new User(usersCount++,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(usersCount++,"Semih", LocalDate.now().minusYears(19)));
        users.add(new User(usersCount++,"Eve", LocalDate.now().minusYears(22)));

    }

    public List<User> findALl(){
        return users;
    }

    public User save(User user){
        users.add(user);
        user.setId(usersCount++);
        return user;
    }

    public User findById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

}
