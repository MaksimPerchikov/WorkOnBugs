package ru.mysait.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "first_type_id")
    private FirstType firstType;

   /* @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;*/

}
