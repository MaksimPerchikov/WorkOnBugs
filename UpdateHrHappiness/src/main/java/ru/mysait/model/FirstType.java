package ru.mysait.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "first_type")
public class FirstType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type_name")
    private String firstTypeName;
}
