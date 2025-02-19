package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PLAYLIST")
public class
 Playlist {

    @Id
    @Column(name = "PLAYLISTID")
    @GeneratedValue
    private int playlistid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER",referencedColumnName = "ID")
    private User user;

    @Column(name = "TITLE")
    private String title;

}

