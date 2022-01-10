package ru.mysait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mysait.dto.UserProjectCardWithAllDto;
/*import ru.mysait.dto.UserWithAllnDto;*/
import ru.mysait.model.UserProjectCard;
import ru.mysait.service.UserProjectCardAllParamImpl;

import java.util.List;

@RestController
@RequestMapping("/my")
public class UserProjectCardRestController {


    private final UserProjectCardAllParamImpl userProjectCardAllParamImpl;
    @Autowired
    public UserProjectCardRestController(UserProjectCardAllParamImpl userProjectCardAllParamImpl) {
        this.userProjectCardAllParamImpl = userProjectCardAllParamImpl;
    }

    @GetMapping(value = "/allN")
    public List<UserProjectCardWithAllDto> findAll(){
        return userProjectCardAllParamImpl.getAllUserWithAllDto();
    }

    @GetMapping(value = "/allUPC")
    public List<UserProjectCard> findAllUserProjectCard(){
        return userProjectCardAllParamImpl.getAllUserProjectCard();
    }

    @PostMapping(value = "/create")
    public List<UserProjectCard> create(@RequestBody UserProjectCardWithAllDto userProjectCardWithAllDto){
        userProjectCardAllParamImpl.converterDtoToEntity(userProjectCardWithAllDto);
        return userProjectCardAllParamImpl.getAllUserProjectCard();
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUserProjectCardById(@PathVariable("id") Long id){
        return userProjectCardAllParamImpl.deleteById(id);
    }

    @DeleteMapping(value = "/deleteAll")
    public String deleteAllUPC(){
        return userProjectCardAllParamImpl.deleteAllUserProjectCard();
    }

}
