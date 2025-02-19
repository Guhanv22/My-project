package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Review")
public class Review {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "audiocastID")
    private int audiocastId;

    @Column(name = "commenttext")
    private String commenttext;

    @Column(name = "reviewdate")
    private Date reviewDate;

    @Column(name = "rating")
    private float rating;
}
