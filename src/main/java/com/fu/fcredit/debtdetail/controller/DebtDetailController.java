package com.fu.fcredit.debtdetail.controller;

import com.fu.fcredit.debtdetail.entity.DebtDetail;
import com.fu.fcredit.debtdetail.service.DebtDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fcredit/debtdetail")
@RequiredArgsConstructor
public class DebtDetailController {
    private final DebtDetailService service;
    @GetMapping("")
        public ResponseEntity<Page<DebtDetail>> getDebtDetail(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                              @RequestParam(name = "size", required = false, defaultValue = "10")Integer pageSize){

        return ResponseEntity.ok(service.getDebtDetail(PageRequest.of(page, pageSize)));
    }

}
