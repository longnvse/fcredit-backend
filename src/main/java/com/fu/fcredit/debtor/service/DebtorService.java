package com.fu.fcredit.debtor.service;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.debtor.repository.DebtorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebtorService {
    private final DebtorRepository repository;
    public Page<Debtor> getDebtors(Pageable pageable){
        return repository.findAll(pageable);
    }
}
