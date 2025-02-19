package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "AUDIOCAST")
public class Audiocast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUDIOCASTID")
    private Long audiocastid;

    @Column(name = "ISAUDIOBOOK")
    private boolean isAudiobook;

    @Column(name = "ISPODCAST")
    private boolean isPodcast;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CREATOR", referencedColumnName = "CREATORID")
    private Creator creator;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GENRE", referencedColumnName = "GENREID")
    private Genre genre;

}

