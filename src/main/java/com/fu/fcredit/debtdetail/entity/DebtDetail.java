package com.fu.fcredit.debtdetail.entity;
import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "debtdetail")
public class DebtDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note")
    private String note;
    @Column(name = "type")
    private String type;
    @Column(name = "debtTotal")
    private Long  debtTotal;
    @Column(name = "createDate")
    private Date creatDate;
    @Column(name = "updateDate")
    private Date updateDate;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Debtor.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "debtor_id")
    private Debtor debtor;


}
