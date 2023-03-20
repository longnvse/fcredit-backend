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
    private final DebtorRepository REPOSITORY;

    public Page<Debtor> getDebtors(Pageable pageable) {
        return REPOSITORY.findAll(pageable);
    }

    public Debtor addDebtor(Debtor debtor) {
        debtor.setDebtTotal(0L);
        return REPOSITORY.save(debtor);
    }

    public Debtor updateDebtor(Long id, Debtor debtor) {
        Debtor oldDebtor = REPOSITORY.findById(id).get();
        oldDebtor.setAddress(debtor.getAddress());
        oldDebtor.setName(debtor.getName());
        oldDebtor.setPhoneNumber(debtor.getPhoneNumber());
        oldDebtor.setEmail(debtor.getEmail());
        return REPOSITORY.save(oldDebtor);
    }

}
