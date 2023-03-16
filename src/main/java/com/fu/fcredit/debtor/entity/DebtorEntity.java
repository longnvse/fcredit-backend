package com.fu.fcredit.debtor.entity;

import com.fu.fcredit.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "debtor")
@Getter
@Setter
public class DebtorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "totalDebt", nullable = false)
    private Long totalDebt;

    @Column(name = "createDate", nullable = false)
    private String dateCreate;

    @Column(name = "modifiedDate", nullable = false)
    private String dateUpdate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
