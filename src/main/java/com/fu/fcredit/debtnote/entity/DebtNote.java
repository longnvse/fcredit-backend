package com.fu.fcredit.debtnote.entity;

import com.fu.fcredit.debtnote.listener.DebtNoteListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(DebtNoteListener.class)
public class DebtNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    private Boolean isDebt;
    private Long money;
    private Date debtDate;
    private Date createDate;
    private String username;
    private Long debtorId;
}
