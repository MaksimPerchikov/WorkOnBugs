package ru.mysait.dto;

import lombok.Data;

@Data
public class UserLocationDto {

    private Long userId;
    private String email;
    private String place;
    private double d;
    private double sh;


}
