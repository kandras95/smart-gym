package com.elte.smartgym.model;

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

    @OneToOne(targetEntity = User.class, optional = false)
    @JoinColumn
    private User user;
}
