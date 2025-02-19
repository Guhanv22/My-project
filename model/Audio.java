package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="Audio")
public class Audio {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="audioID")
     private int audioId;


    @Column(name = "audiocastID")
    private int audiocastId;

    @Column(name = "languageID")
    private int languageId;

    @Column(name = "title")
    private String title;

    @Column(name = "releasedate")
    private Date releaseDate;

    @Column(name = "rating")
    private float rating;

    @Column(name = "audiofile")
    private String audioFile;

    @Column(name = "price")
    private double price;

    @Column(name = "imageUrl")
    private String imageUrl;

    public String getFullImageUrl() {
        return "/assets/images/" + this.imageUrl;
    }
    public String getFullAudioFilePath() {
        return "/assets/audio/" + this.audioFile;
    }
}
