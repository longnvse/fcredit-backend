package com.fu.fcredit.auth.debtdetail.repository;

import com.fu.fcredit.auth.debtdetail.entity.DebtDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtDetailRepository extends JpaRepository<DebtDetail, Long> {


}
