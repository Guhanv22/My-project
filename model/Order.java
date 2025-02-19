package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.web.JsonPath;

import java.util.Date;

@Entity
@Data
@Table(name = "Orders")
public class Order {
    @Id
    @Column(name="OrderID")
    @GeneratedValue
    private int orderid;

    @Column(name="orderdate")
    private Date orderdate;

    @Column(name="totalamount")
    private Float totalamount;

    @Column(name="orderstatus")
    private String orderstatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "user",referencedColumnName = "id")
    private User id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "audiocast",referencedColumnName = "audiocastid")
    private Audiocast audiocast;


}
