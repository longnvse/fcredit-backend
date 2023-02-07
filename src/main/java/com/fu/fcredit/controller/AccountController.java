package com.fu.fcredit.controller;

import com.fu.fcredit.entity.Account;
import com.fu.fcredit.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class AccountController {
//    @Autowired
//    private AccountRepository accountRepository;

//    @GetMapping("/accounts")
//    public List<Account> getAllAccounts() {
////        return accountRepository.findAll();
//    }
}
