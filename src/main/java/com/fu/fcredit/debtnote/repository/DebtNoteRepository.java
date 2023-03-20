package com.fu.fcredit.debtnote.repository;

import com.fu.fcredit.debtnote.entity.DebtNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtNoteRepository extends JpaRepository<DebtNote,Long> {
}
