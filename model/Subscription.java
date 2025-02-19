package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Subscription")
public class Subscription {

    @Id
    @Column(name = "subscriptionid")
    @GeneratedValue
    private int subscriptionid;
    @Column(name = "plantype")
    private String plantype;


    @Column(name="startdate")
    private Date startdate;

    @Column(name="enddate")
    private Date enddate;

    @Column(name="renewalstatus")
    private String renewalstatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "user",referencedColumnName = "id")
    private User userid;
}
