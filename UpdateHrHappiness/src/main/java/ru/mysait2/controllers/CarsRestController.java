package ru.mysait2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mysait2.dto.CarDao;
import ru.mysait2.model.Cars;
import ru.mysait2.service.CarsInterfaceImp;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsRestController {

    private final CarsInterfaceImp carsInterfaceImp;

    @Autowired
    public CarsRestController(CarsInterfaceImp carsInterfaceImp){
        this.carsInterfaceImp  = carsInterfaceImp;

    }

    @PostMapping(value = "/create")
    public String createCar(@RequestBody CarDao carDao){
        return carsInterfaceImp.addNewCar(carDao);
    }

    @GetMapping(value = "/allE")
    public List<Cars> findAllCarsEntity(){
        return carsInterfaceImp.findAllCarsEnt();
    }
}
