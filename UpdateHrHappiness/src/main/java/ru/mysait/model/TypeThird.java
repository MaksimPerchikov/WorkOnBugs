package ru.mysait.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TypeThird {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type_a")
    private String typeA;

    @Column(name = "type_b")
    private String typeB;

    @Column(name = "type_c")
    private String typeC;
}
