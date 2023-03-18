package com.fu.fcredit.debtor.entity;

import jakarta.persistence.*;

@Entity
public class Debtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private String phone_num;

    @Column
    private String email;

    @Column()
    private Long totalDebt;

    public Debtor() {
    }

    public Debtor(Long id, String name, String address, String phone_num, String email, Long totalDebt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_num = phone_num;
        this.email = email;
        this.totalDebt = totalDebt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(Long totalDebt) {
        this.totalDebt = totalDebt;
    }
}
