package com.fu.fcredit.debtnote.validate;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.repository.DebtNoteRepository;
import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.exception.BadRequestException;

public class DebtNoteValidate {
    private final DebtNoteRepository repository;

    public DebtNoteValidate(DebtNoteRepository repository) {
        this.repository = repository;
    }

    public void validateForAddDebtNote(DebtNote debtNote) {
        this.isNotMoney(debtNote.getMoney(), "Vui long nhap money");
    }


    private void isNotMoney(Long value, String errorMsg) {
        if (null == value) {
            throw new BadRequestException(errorMsg);

        }

    }

//    private void isValid(String) {
//    }
}

