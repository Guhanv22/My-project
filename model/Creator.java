package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Creator")
public class Creator {

    @Id
    @Column(name = "CREATORID")
    @GeneratedValue
    private int creatorid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASWORD")
    private String password;

    @Column(name = "BIO")
    private String bio;

    @Column(name = "QUALIFICATION")
    private String qualification;

    @Column(name = "NATIONLITY")
    private String nationality;

}
