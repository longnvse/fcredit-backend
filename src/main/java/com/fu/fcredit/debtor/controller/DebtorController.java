package com.fu.fcredit.debtor.controller;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.debtor.service.DebtorService;
import com.fu.fcredit.debtor.validate.DebtorValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fcredit/debtors")
@RequiredArgsConstructor
public class DebtorController {
    private final DebtorService service;
    private final DebtorValidate validator;

    @GetMapping("")
    public ResponseEntity<Page<Debtor>> getDebtors(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                   @RequestParam(name = "size", required = false, defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(service.getDebtors(PageRequest.of(page, pageSize)));
    }

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
}
