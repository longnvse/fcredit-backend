package com.fu.fcredit.debtnote.controller;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.service.DebtNoteService;
import com.fu.fcredit.debtnote.validate.DebtNoteValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Repository
@RequestMapping("api/v1/fcredit/debt-notes")
@RequiredArgsConstructor

public class DebtNoteController {
    private final DebtNoteService service;
    private final DebtNoteValidate validator;

    @GetMapping("")
    public ResponseEntity<Page<DebtNote>> getDebtDetail(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                        @RequestParam(name = "size", required = false, defaultValue = "10") Integer pageSize) {

        return ResponseEntity.ok(service.getDebtDetail(PageRequest.of(page, pageSize)));
    }

    @PostMapping({""})
    public ResponseEntity<DebtNote> addDebtNote(@RequestBody DebtNote debtNote) {
        validator.validateForAddDebtNote(debtNote);
        return ResponseEntity.ok(service.addDebtnote(debtNote));
    }

}
