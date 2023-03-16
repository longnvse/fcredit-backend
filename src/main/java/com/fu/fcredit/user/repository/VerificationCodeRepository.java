package com.fu.fcredit.user.repository;

import com.fu.fcredit.user.entity.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    VerificationCode findVerificationCodeByToken(String token);

}
