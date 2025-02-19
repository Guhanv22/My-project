package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "HISTORY")
public class
History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORYID")
    private int historyid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    private User user;

    @Column(name = "AUDIOID")
    private int audioid;



    @Column(name = "LASTLISTENED")
    private Date lastlistened;
}
