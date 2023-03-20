package com.fu.fcredit.debtnote.validate;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.repository.DebtNoteRepository;
import com.fu.fcredit.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DebtNoteValidate {
    private final DebtNoteRepository repository;

    public void validateForAddDebtNote(DebtNote debtNote) {
        isNotMoney(debtNote.getMoney(), "Vui long nhap money");
    }


    private void isNotMoney(Long value, String errorMsg) {
        if (null == value) {
            throw new BadRequestException(errorMsg);

        }

    }
}

