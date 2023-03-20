package com.fu.fcredit.debtnote.controller;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.service.DebtNoteService;
import com.fu.fcredit.debtnote.validate.DebtNoteValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("api/v1/fcredit/debt-notes")
@RequiredArgsConstructor

public class DebtNoteController {
    private final DebtNoteService service;
    private final DebtNoteValidate validator;

    @PostMapping({""})
    public ResponseEntity<DebtNote> addDebtNote(@RequestBody DebtNote debtNote) {
        validator.validateForAddDebtNote(debtNote);
        return ResponseEntity.ok(service.addDebtnote(debtNote));
    }

}
