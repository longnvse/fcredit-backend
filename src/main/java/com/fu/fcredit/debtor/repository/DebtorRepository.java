package com.fu.fcredit.debtor.repository;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtorRepository extends JpaRepository<Debtor, Long> {
}
