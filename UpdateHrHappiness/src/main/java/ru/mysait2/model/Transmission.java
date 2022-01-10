package ru.mysait2.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Transmission {

    @Id
    @GeneratedValue
    private Long idTransmission;
    private String typeTransmission;
}
