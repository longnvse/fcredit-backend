package com.fu.fcredit.debtnote.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.Update;

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
    private Boolean dateType;
    private Long money;
    private Date createDate;




}
