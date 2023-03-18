package com.fu.fcredit.debtor.service;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.debtor.repository.DebtorRepository;
import org.springframework.stereotype.Service;

@Service
public class DebtorService {
    private final DebtorRepository repository;

    public Debtor addDebtor(Debtor debtor) {
        debtor.setTotalDebt(0L);
        return repository.save(debtor);
    }

    public Debtor updateDebtor(Long id, Debtor debtor) {
        Debtor oldDebtor = repository.findById(id).get();
        oldDebtor.setAddress(debtor.getAddress());
        oldDebtor.setName(debtor.getName());
        oldDebtor.setPhone_num(debtor.getPhone_num());
        oldDebtor.setEmail(debtor.getEmail());
        return repository.save(oldDebtor);
    }

    public DebtorService( final DebtorRepository repository) {
        this.repository = repository;
    }
}
