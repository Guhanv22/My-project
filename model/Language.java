package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Language")
public class Language {
    @Id
    @Column(name = "LANGUAGEID")
    @GeneratedValue
    private int languageid;

    @Column(name = "NAME")
    private String name;
}
