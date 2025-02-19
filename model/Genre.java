package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Genre")
public class Genre {

    @Id
    @Column(name ="GENREID")
    @GeneratedValue
    private int genreid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}