package com.fu.fcredit.debtnote.validate;

import com.fu.fcredit.debtnote.entity.DebtNote;
import com.fu.fcredit.debtnote.repository.DebtNoteRepository;
import com.fu.fcredit.debtor.validate.DebtorValidate;
import com.fu.fcredit.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DebtNoteValidate {
    private final DebtNoteRepository repository;
    private final DebtorValidate debtorValidate;

    public void validateForAddDebtNote(Long debtorId,
                                       DebtNote debtNote) {
        debtorValidate.validateForExistDebtor(debtorId);
        isNotMoney(debtNote.getMoney(), "Vui lòng nhập số tiền!");
    }

    private void isNotMoney(Long value, String errorMsg) {
        if (null == value) {
            throw new BadRequestException(errorMsg);

        }

    }
}

