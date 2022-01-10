package ru.mysait2.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Model {
    @Id
    @GeneratedValue
    private Long idModel;

    private String modelName;

}
