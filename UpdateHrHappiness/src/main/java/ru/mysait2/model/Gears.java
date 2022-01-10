package ru.mysait2.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Gears {

    @Id
    @GeneratedValue
    private Long idGear;

    private String nameGear;
}
