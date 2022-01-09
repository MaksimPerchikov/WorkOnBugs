package ru.mysait.model;

import lombok.*;
import ru.mysait.model.useInformation.User;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "user_project_card")
public class UserProjectCard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name_project")
    private String nameProject;

    @Column(name = "customer_name")
    private String customerName;

    @OneToOne
    @JoinColumn(name = "first_type_id")
    private FirstType firstType;

    @OneToOne
    @JoinColumn(name="second_type_id")
    private SecondType secondType;

    @ManyToOne//@OneToOne тоже подходит,странно
    @JoinColumn(name = "user_id")
    private User user;

}
