package com.fu.fcredit.debtdetail.service;

import com.fu.fcredit.debtdetail.entity.DebtDetail;
import com.fu.fcredit.debtdetail.repository.DebtDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebtDetailService {
    private final DebtDetailRepository repository;

    public Page<DebtDetail> getDebtDetail(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
