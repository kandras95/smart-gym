package com.elte.smartgym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer creativity;

    @Column
    private Integer quality;

    @Column
    private Integer efficiency;

    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn
    @JsonIgnore
    private User user;
}
