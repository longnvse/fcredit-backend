package com.fu.fcredit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Deptor")
@Getter
@Setter
public class DeptorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private int phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "totalDept", nullable = false)
    private int totalDept;

    @Column(name = "dateCreate", nullable = false)
    private String dateCreate;

    @Column(name = "dateUpdate", nullable = false)
    private String dateUpdate;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private AccountEntity account;

}
