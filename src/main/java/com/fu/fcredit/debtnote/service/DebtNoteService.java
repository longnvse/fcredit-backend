package com.fu.fcredit.debtnote.service;

import com.fu.fcredit.debtnote.repository.DebtNoteRepository;
import org.springframework.stereotype.Service;


import com.fu.fcredit.debtnote.entity.DebtNote;
@Service

public class DebtNoteService {
    private final DebtNoteRepository REPOSITORY;

    public DebtNoteService(DebtNoteRepository repository) {
        REPOSITORY = repository;
    }

    public DebtNote addDebtnote(DebtNote debtNote){
        return REPOSITORY.save(debtNote);
    }
}
