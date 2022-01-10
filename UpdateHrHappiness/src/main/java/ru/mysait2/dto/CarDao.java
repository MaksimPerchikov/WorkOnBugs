package ru.mysait2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CarDao {

    private Integer numberCar;
    private String color;
    private String model;
    private String engineName;
    private String gearsNameByEngine;
    private String transmission;
}
