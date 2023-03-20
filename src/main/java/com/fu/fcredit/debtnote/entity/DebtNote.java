package com.fu.fcredit.debtnote.entity;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "debt-note")
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
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Debtor.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "debtor_id")
    private Debtor debtor;
}
