package com.fu.fcredit.debtnote.service;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.repository.DebtNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DebtNoteService {
    private final DebtNoteRepository repository;

    public Page<DebtNote> getDebtDetail(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public DebtNote addDebtnote(DebtNote debtNote) {
        debtNote.setCreateDate(new Date());

        return repository.save(debtNote);
    }


}
