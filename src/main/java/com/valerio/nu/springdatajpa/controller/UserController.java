package com.valerio.nu.springdatajpa.controller;

import com.valerio.nu.springdatajpa.model.User;
import com.valerio.nu.springdatajpa.service.SimpleUserImpl;
import com.valerio.nu.springdatajpa.service.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;




@RestController
public class UserController {
    private final SimpleUserImpl userService;

    public UserController(SimpleUserImpl userService, UserRepository userRepository) {
        this.userService = userService;
    }

    // Add
    @PostMapping(value = "/users")
    public User Post(@RequestBody User params) {
        return userService.Post(params);
    }



    // Get
    @GetMapping(value = "/users")
    public List<User> Get() {

        return userService.Get();
    }

    // Get By ID
    @GetMapping(value = "/users/{id}")
    public EntityModel<User> Get(@PathVariable int id) {





        User result = userService.Get(id);
                if(result == null){
                    throw new ObjectNotFoundException("no user exist with such id: " ,  String.valueOf(id));
                }

            return EntityModel.of(result, //
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).Get(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).Get()).withRel("all-users"));


    }



    // Update
    @PutMapping(value = "/users/{id}")
    public User Update(@PathVariable int id, @RequestBody User params) {
        return userService.Update(params, id);
    }

    // Delete
    @DeleteMapping(value = "/users/{id}")
    public String Delete(@PathVariable int id) {
        return userService.Delete(id);
    }

}