package com.fu.fcredit.debtnote.controller;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.service.DebtNoteService;
import com.fu.fcredit.debtor.service.DebtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("api/v1/fcredit/debtNote")
@RequiredArgsConstructor

public class DebtNoteController {
    private final DebtNoteService service;



}
