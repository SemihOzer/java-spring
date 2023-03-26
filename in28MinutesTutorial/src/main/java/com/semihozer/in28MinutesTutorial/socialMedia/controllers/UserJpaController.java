package com.semihozer.in28MinutesTutorial.socialMedia.controllers;

        import com.semihozer.in28MinutesTutorial.socialMedia.dataAccsess.PostRepository;
        import com.semihozer.in28MinutesTutorial.socialMedia.dataAccsess.UserDaoService;
        import com.semihozer.in28MinutesTutorial.socialMedia.dataAccsess.UserRepository;
        import com.semihozer.in28MinutesTutorial.socialMedia.entities.Post;
        import com.semihozer.in28MinutesTutorial.socialMedia.entities.User;
        import com.semihozer.in28MinutesTutorial.socialMedia.exceptions.UserNotFoundException;
        import jakarta.validation.Valid;
        import lombok.AllArgsConstructor;
        import org.springframework.hateoas.EntityModel;
        import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

        import java.net.URI;
        import java.util.List;
        import java.util.Optional;

        import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@AllArgsConstructor
public class UserJpaController {

    private UserRepository userRepository;

    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> findById(@PathVariable int id){

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());

        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/delete/{id}")
    public void deleteUser(@PathVariable int id){

        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/getPosts/user/{id}")
    public List<Post> getPosts(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        List<Post> posts = user.get().getPosts();

        return posts;

    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        System.out.println(ResponseEntity.created(location).build());
        return ResponseEntity.created(location).build();

    }



}
