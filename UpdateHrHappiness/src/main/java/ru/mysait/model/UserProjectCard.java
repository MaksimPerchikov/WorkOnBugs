package ru.mysait.model;

import lombok.*;

import javax.persistence.*;

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

   /* @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;*/

}
