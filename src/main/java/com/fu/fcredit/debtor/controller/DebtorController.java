package com.fu.fcredit.debtor.controller;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.debtor.service.DebtorService;
import com.fu.fcredit.debtor.validate.DebtorValidate;
import com.fu.fcredit.page.PageResponse;
import com.fu.fcredit.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fcredit/debtors")
@RequiredArgsConstructor
public class DebtorController {
    private final DebtorService service;
    private final DebtorValidate validator;

    @GetMapping("")
    public ResponseEntity<PageResponse> getDebtors(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                   @RequestParam(name = "size", required = false, defaultValue = "10") Integer pageSize,
                                                   @RequestHeader("Authorization") String token) {

        Page<Debtor> debtors = service.getDebtors(token, PageRequest.of(page, pageSize));

        return ResponseEntity.ok(MapperUtil.mapPageResponseFromPage(debtors));
    }

    @GetMapping("/top/desc")
    public ResponseEntity<List<Debtor>> getTopDebtTotalDesc(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.getTopDebtTotalDesc(token));
    }

    @GetMapping("/top/asc")
    public ResponseEntity<List<Debtor>> getTopDebtTotalAsc(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.getTopDebtTotalAsc(token));
    }

    @PostMapping({""})
    public ResponseEntity<Debtor> addDebtor(@RequestBody Debtor debtor,
                                            @RequestParam("username") String username) {
        validator.validateForAdd(debtor);
        return ResponseEntity.ok(service.addDebtor(debtor, username));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Debtor> updateDebtor(@PathVariable("id") Long id, @RequestBody Debtor debtor) {
        validator.validateForUpdate(id, debtor);
        return ResponseEntity.ok(service.updateDebtor(id, debtor));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Debtor> getDebtor(@PathVariable("id") Long id) {
        validator.validateForExistDebtor(id);
        return ResponseEntity.ok(service.getDebtor(id));
    }
}
