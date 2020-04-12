package com.elte.smartgym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer difficulty;

    @ManyToMany
    private List<Exercise> exercises;

    @OneToMany(targetEntity = User.class, mappedBy = "plan")
    @JsonIgnore
    private List<User> users;

    public void removeExercise(Exercise exercise) {
        this.exercises.remove(exercise);
    }
}
