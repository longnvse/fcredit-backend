package com.fu.fcredit.debtor.validate;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.debtor.repository.DebtorRepository;
import com.fu.fcredit.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class DebtorValidate {

    private final DebtorRepository repository;


    public void validateForAdd(Debtor debtor) {
        this.isNotPopulated(debtor.getName(), "Vui lòng nhập họ tên!");
        this.validateForValidEmail(debtor.getEmail());
        this.validateForValidPhone(debtor.getPhoneNumber());
    }

    public void validateForUpdate(Long id, Debtor debtor) {
        this.validateForExistDebtor(id);
        this.validateForAdd(debtor);
    }

    public void validateForExistDebtor(Long id) {
        if (!this.repository.existsById(id)) {
            throw new BadRequestException("Người nợ không tồn tại!");
        }
    }

    private void isNotPopulated(String value, String errorMsg) {
        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }

    //"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
    public void validateForValidEmail(String email) {
        if (email != null) {
            this.validatorRegexField(email, "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", "Email không đúng định dạng!");
        }
    }

    public void validateForValidPhone(String phone) {
        if (phone != null) {
            this.validatorRegexField(phone, "^[0-9]{10}$", "Số điện thoại không đúng định dạng!");
        }
    }

    private void validatorRegexField(String value, String pattern, String errorMsg) throws BadRequestException {
        Pattern pt = Pattern.compile(pattern, 2);
        Matcher matcher = pt.matcher(value);
        if (!matcher.find()) {
            throw new BadRequestException(errorMsg);
        }
    }
}
