package com.fu.fcredit.debtor.controller;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.debtor.service.DebtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fcredit/debtor")
@RequiredArgsConstructor
public class DebtorController {
    private final DebtorService service;

    @GetMapping("")
    public ResponseEntity<Page<Debtor>> getDebtors(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                   @RequestParam(name = "size", required = false, defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(service.getDebtors(PageRequest.of(page, pageSize)));
    }
}
