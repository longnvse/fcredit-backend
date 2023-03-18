package com.fu.fcredit.debtor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "debtor")
@NoArgsConstructor
@AllArgsConstructor
public class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "debtTotal")
    private Long debtTotal;
    @Column(name = "createDay")
    private Date createDay;
    @Column(name = "updatedDay")
    private Date updatedDay;

}
