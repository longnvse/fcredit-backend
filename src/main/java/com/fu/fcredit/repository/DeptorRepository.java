package com.fu.fcredit.repository;

import com.fu.fcredit.entity.DeptorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptorRepository extends JpaRepository<DeptorEntity, Long> {
}
