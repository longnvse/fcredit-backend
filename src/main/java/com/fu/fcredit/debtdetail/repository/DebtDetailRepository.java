package com.fu.fcredit.debtdetail.repository;

import com.fu.fcredit.debtdetail.entity.DebtDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DebtDetailRepository extends JpaRepository<DebtDetail, Long> {

}
