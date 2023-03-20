package com.fu.fcredit.auth.debtdetail.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class DebtDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String note;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String  money;
    @Column(nullable = false)
    private Date creatDate;
    @Column(nullable = false)
    private Date updateDate;




}
