package com.fu.fcredit.debtor.repository;

import com.fu.fcredit.debtor.entity.Debtor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtorRepository extends JpaRepository<Debtor, Long> {
    Page<Debtor> findAllByUsernameOrderByUpdatedDateDesc(String username, Pageable pageable);

    List<Debtor> findTop5ByUsernameOrderByDebtTotalDesc(String username);

    List<Debtor> findTop5ByUsernameOrderByDebtTotalAsc(String username);
}