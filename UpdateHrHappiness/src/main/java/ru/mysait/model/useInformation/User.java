package ru.mysait.model.useInformation;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;

    @OneToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
