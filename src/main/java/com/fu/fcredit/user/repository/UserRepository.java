package com.fu.fcredit.user.repository;

import com.fu.fcredit.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameIgnoreCase(String username);

    Boolean existsByEmailIgnoreCase(String email);

    Boolean existsUserByUsernameIgnoreCase(String username);
}