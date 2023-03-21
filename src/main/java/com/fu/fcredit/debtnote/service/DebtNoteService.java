package com.fu.fcredit.debtnote.service;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.repository.DebtNoteRepository;
import com.fu.fcredit.exception.EntityNotFoundException;
import com.fu.fcredit.page.PageResponse;
import com.fu.fcredit.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DebtNoteService {
    private final DebtNoteRepository repository;

    public PageResponse getDebtNotes(Long debtorId, Pageable pageable) {
        Page<DebtNote> debtNotes = repository.findAllByDebtorIdOrderByCreateDateDesc(debtorId, pageable);
        return MapperUtil.mapPageResponseFromPage(debtNotes);
    }

    public DebtNote getDebtNotes(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Phiếu nợ không tồn tại!"));
    }

    public DebtNote addDebtnote(Long debtorId,
                                DebtNote debtNote,
                                String username) {
        debtNote.setCreateDate(new Date());
        debtNote.setDebtorId(debtorId);
        debtNote.setUsername(username);

        return repository.save(debtNote);
    }

}
