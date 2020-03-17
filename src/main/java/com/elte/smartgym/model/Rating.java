package com.elte.smartgym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
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
