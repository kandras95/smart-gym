package com.elte.smartgym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer difficulty;

    @Column
    private String description;

    @ManyToMany(mappedBy = "exercises")
    @JsonIgnore
    private List<Plan> plans;
}
