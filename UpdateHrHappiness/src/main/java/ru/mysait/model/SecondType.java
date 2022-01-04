package ru.mysait.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "second_type")
public class SecondType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "second_type_name")
    private String secondTypeName;
}
