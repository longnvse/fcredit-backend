package com.fu.fcredit.debtor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "debtor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Long debtTotal;
    private Date createDate;
    private Date updatedDate;


}
