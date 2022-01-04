package ru.mysait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mysait.dto.UserProjectCardWithAllDto;
/*import ru.mysait.dto.UserWithAllnDto;*/
import ru.mysait.service.UserProjectCardAllParamImpl;

import java.util.List;

@RestController
@RequestMapping("/my")
public class UserLocationRestController {


    private final UserProjectCardAllParamImpl userFirstType;
    @Autowired
    public UserLocationRestController(UserProjectCardAllParamImpl userFirstType) {
        this.userFirstType = userFirstType;
    }

    @GetMapping(value = "/allN")
    public List<UserProjectCardWithAllDto> findAll(){
        return userFirstType.getAllUserWithAllDto();
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody UserProjectCardWithAllDto userProjectCardWithAllDto) throws Exception {
        userFirstType.converterDtoToEntity(userProjectCardWithAllDto);
    }
}
