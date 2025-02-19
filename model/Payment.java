package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Payment")
public class Payment {
    @Id
    @Column(name = "PAYMENTID")
    @GeneratedValue
    private int paymentid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "Orders",referencedColumnName = "orderid")
    private Order order;


    @Column(name = "AMOUNTPAID")
    private float amountpaid;
    @Column(name = "PAYMENTMETHOD")
    private String paymentmethod;
    @Column(name = "PAYMENTDATE")
    private Date paymentdate;
    @Column(name = "PAYMENTSTATUS")
    private String paymentstatus;


}
