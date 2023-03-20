package com.fu.fcredit.debtnote.service;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.repository.DebtNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DebtNoteService {
    @Autowired
    private final DebtNoteRepository repository;

    public Page<DebtNote> getDebtDetail(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public DebtNote addDebtnote(DebtNote debtNote) {
        debtNote.setCreateDate(new Date());

        return repository.save(debtNote);
    }
    public DebtNote getDebtNoteById(Long id){
        Optional<DebtNote> debtorNote = repository.findById(id);

        return debtorNote.get();
    }


}
