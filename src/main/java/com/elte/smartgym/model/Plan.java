package com.elte.smartgym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer popularity;

    @ManyToMany
    @JsonIgnore
    private List<Exercise> exercises;

    @OneToMany(targetEntity = User.class, mappedBy = "plan")
    @JsonIgnore
    private List<User> users;
}
