package com.huallpa.rest.webservices.restfulwebservices.user;

import com.huallpa.rest.webservices.restfulwebservices.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("Id-" + id);
        }
        return user;
    }

    @DeleteMapping(path = "/users/{id}")
    public User deleteUser(@PathVariable Integer id) {
        User user = userService.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("Id-" + id);
        }
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity createUser(@Validated @RequestBody User user) {
        User userCreated = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
