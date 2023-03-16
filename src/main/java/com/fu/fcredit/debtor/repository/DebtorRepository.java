package com.fu.fcredit.debtor.repository;

import com.fu.fcredit.debtor.entity.DebtorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtorRepository extends JpaRepository<DebtorEntity, Long> {
}
