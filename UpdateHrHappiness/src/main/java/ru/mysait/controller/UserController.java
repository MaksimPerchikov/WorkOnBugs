package ru.mysait.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mysait.model.useInformation.User;
import ru.mysait.service.interfeces.UserInterface;

@RestController
@RequestMapping("/u")
public class UserController {

    private final UserInterface userInterface;

    @Autowired
    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @GetMapping(value = "/{id}")
    public String findUserById(@PathVariable("id") Long id){
        return userInterface.findByIdUser(id);
    }

    @PostMapping(value = "/create")
    public User addUser(@PathVariable User user){
        return userInterface.addUser(user);
    }

    @GetMapping(value = "/all")
    public String findAllUser(){
        return userInterface.findAllUsers();
    }

}
