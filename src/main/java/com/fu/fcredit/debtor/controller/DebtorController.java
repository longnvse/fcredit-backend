package com.fu.fcredit.debtor.controller;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.debtor.service.DebtorService;
import com.fu.fcredit.debtor.validate.DebtorValidate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/v1/fcredit/debtors"})
public class DebtorController {
    private final DebtorService service;
    private final DebtorValidate validator;

    @PostMapping({""})
    public ResponseEntity<Debtor> addDebtor(@RequestBody Debtor debtor) {
        this.validator.validateForAdd(debtor);
        return ResponseEntity.ok(this.service.addDebtor(debtor));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Debtor> updateDebtor(@PathVariable("id") Long id, @RequestBody Debtor debtor) {
        this.validator.validateForUpdate(id, debtor);
        return ResponseEntity.ok(this.service.updateDebtor(id, debtor));
    }

    public DebtorController(final DebtorService service, final DebtorValidate validator) {
        this.service = service;
        this.validator = validator;
    }
}
