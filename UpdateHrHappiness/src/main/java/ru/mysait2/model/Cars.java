package ru.mysait2.model;

import lombok.*;
import org.springframework.boot.SpringBootVersion;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cars {

    @Id
    @GeneratedValue
    private Long idCar;
    private Integer numberCar;
    private String color;

    @OneToOne
    @JoinColumn(name = "model_idModel")
    private Model model;

    @OneToOne
    @JoinColumn(name = "engineType_idEngineType")
    private EngineType engineType;

    @OneToOne
    @JoinColumn(name = "transmission_idTransmission")
    private Transmission transmission;

}
