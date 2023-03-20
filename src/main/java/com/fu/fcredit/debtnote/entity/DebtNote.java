package com.fu.fcredit.debtnote.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="debtnote")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class DebtNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    private Boolean isDebt;
    private Long money;
    private Date debtDate;
    private Date createDate;




}
