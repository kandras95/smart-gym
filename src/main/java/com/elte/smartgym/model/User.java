package com.elte.smartgym.model;

import com.elte.smartgym.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String e_mail;

    @Column
    private Integer weight;

    @Column
    private Integer goal_weight;

    @Column
    private Integer height;

    @Column
    private Integer score;

    @ManyToOne(targetEntity = Plan.class, optional = false)
    @JoinColumn
    private Plan plan;

    @OneToMany(targetEntity = Rating.class, mappedBy = "user")
    private List<Rating> ratings;
}
