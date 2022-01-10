package ru.mysait2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EngineType {

    @Id
    @GeneratedValue
    private Long idEngineType;

    private String nameEngine;

    @OneToOne
    @JoinColumn(name = "gears_idGear")
    private Gears gears;
}
