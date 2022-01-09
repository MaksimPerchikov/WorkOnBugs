package ru.mysait.model.useInformation;

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
public class Faculty {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "faculty_name")
    private String facultyName;

}
