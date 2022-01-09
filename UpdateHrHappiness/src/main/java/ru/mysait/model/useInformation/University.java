package ru.mysait.model.useInformation;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class University {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "university_name")
    private String universityName;
}
