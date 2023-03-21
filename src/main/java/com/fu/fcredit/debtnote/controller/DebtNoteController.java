package com.fu.fcredit.debtnote.controller;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.service.DebtNoteService;
import com.fu.fcredit.debtnote.validate.DebtNoteValidate;
import com.fu.fcredit.page.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Repository
@RestController
@RequestMapping("api/v1/fcredit/debt-notes")
@RequiredArgsConstructor
public class DebtNoteController {
    private final DebtNoteService service;
    private final DebtNoteValidate validator;

    @GetMapping("/{debtorId}")
    public ResponseEntity<PageResponse> getDebtDetail(
            @PathVariable("debtorId") Long debtorId,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer pageSize) {

        return ResponseEntity.ok(service.getDebtNotes(debtorId, PageRequest.of(page, pageSize)));
    }

    @PostMapping({"/{debtorId}"})
    public ResponseEntity<DebtNote> addDebtNote(@PathVariable("debtorId") Long debtorId,
                                                @RequestBody DebtNote debtNote,
                                                @RequestParam("username") String username) {
        validator.validateForAddDebtNote(debtorId, debtNote);

        return ResponseEntity.ok(service.addDebtnote(debtorId, debtNote, username));
    }

    @GetMapping({"/detail/{id}"})
    public ResponseEntity<DebtNote> addDebtNote(@PathVariable("id") Long debtorId) {
        return ResponseEntity.ok(service.getDebtNotes(debtorId));
    }

}
