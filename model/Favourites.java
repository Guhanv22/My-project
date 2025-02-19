package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Favourites")
public class Favourites {

    @Id
    @Column(name = "FAVOURITESID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favouritesid;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER", referencedColumnName = "ID")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "AUDIOCASTID", referencedColumnName = "AUDIOCASTID")
    private Audiocast audiocast;
}
