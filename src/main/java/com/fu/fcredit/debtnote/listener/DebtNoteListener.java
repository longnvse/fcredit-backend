package com.fu.fcredit.debtnote.listener;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtor.service.DebtorService;
import jakarta.persistence.PostPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DebtNoteListener {

    private static DebtorService debtorService;

    @Autowired
    public void setDebtorService(DebtorService debtorService) {
        this.debtorService = debtorService;
    }

    @PostPersist
    private void afterAddDebtNote(DebtNote debtNote) {
        if (debtNote.getIsDebt()) {
            debtorService.updateDebtorDebtTotal(debtNote.getDebtorId(), debtNote.getMoney());
        } else {
            debtorService.updateDebtorDebtTotal(debtNote.getDebtorId(), -debtNote.getMoney());
        }
    }
}
