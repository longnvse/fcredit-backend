package com.fu.fcredit.user.validate;

import com.fu.fcredit.exception.BadRequestException;
import com.fu.fcredit.exception.EntityNotFoundException;
import com.fu.fcredit.user.entity.VerificationCode;
import com.fu.fcredit.user.repository.VerificationCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VerificationCodeValidator {
    private final VerificationCodeRepository repository;

    public void validateForExistToken(String token) {
        VerificationCode verificationCode = repository.findVerificationCodeByToken(token);

        if (verificationCode != null) {
            return;
        }

        throw new EntityNotFoundException("Liên kết không tồn tại!");
    }

    public void validateForExpired(String token) {
        VerificationCode verificationCode = repository.findVerificationCodeByToken(token);

        if (verificationCode.getExpiryDate().before(new Date())) {
            throw new BadRequestException("Liên kết đã hết hạn!");
        }
    }

    public void validateForUsed(String token) {
        VerificationCode verificationCode = repository.findVerificationCodeByToken(token);

        if (!verificationCode.isUsed()) {
            return;
        }

        throw new BadRequestException("Liên kết đã được sử dụng!");
    }
}
