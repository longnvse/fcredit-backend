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

    public Page<Debtor> getDebtors(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Debtor addDebtor(Debtor debtor) {
        debtor.setDebtTotal(0L);
        return repository.save(debtor);
    }

    public Debtor updateDebtor(Long id, Debtor debtor) {
        Debtor oldDebtor = repository.findById(id).get();
        oldDebtor.setAddress(debtor.getAddress());
        oldDebtor.setName(debtor.getName());
        oldDebtor.setPhoneNumber(debtor.getPhoneNumber());
        oldDebtor.setEmail(debtor.getEmail());
        return repository.save(oldDebtor);
    }

}
