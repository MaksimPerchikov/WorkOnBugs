package ru.mysait.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SecondType {

    @Id
    @GeneratedValue
    private Long id;
    private String secondTypeName;
}
