
package com.example.audible.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Data
@Table(name = "User")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NAME")
    private String name;
}
