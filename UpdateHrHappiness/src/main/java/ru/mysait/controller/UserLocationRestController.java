package ru.mysait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mysait.dto.UserLocationDto;
import ru.mysait.service.UserLocationServiceImpl;
import ru.mysait.service.interfeces.UserLocationService;

import java.util.List;

@RestController
@RequestMapping("/my")
public class UserLocationRestController {

    private final UserLocationServiceImpl userLocationServiceImpl;

    @Autowired
    public UserLocationRestController(UserLocationServiceImpl userLocationServiceImpl) {
        this.userLocationServiceImpl = userLocationServiceImpl;
    }

    @GetMapping(value = "/all")
    public List<UserLocationDto> findAllUserLocationDto(){
        return userLocationServiceImpl.getAllUserLocationDto();
    }
}
