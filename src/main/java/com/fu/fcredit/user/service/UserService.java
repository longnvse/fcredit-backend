package com.fu.fcredit.user.service;

import com.fu.fcredit.exception.EntityNotFoundException;
import com.fu.fcredit.user.entity.User;
import com.fu.fcredit.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User updateUser(String username, User newUser) {

        User user = repository.findUserByUsernameIgnoreCase(username).orElseThrow(() -> new EntityNotFoundException("Người dùng không tồn tại!"));

        user.setDescription(newUser.getDescription());
        user.setFullName(newUser.getFullName());
        user.setPhoneNumber(newUser.getPhoneNumber());

        return repository.save(user);
    }

    public User getUser(String username) {

        return repository.findUserByUsernameIgnoreCase(username)
                .orElseThrow(() -> new EntityNotFoundException("Người dùng không tồn tại!"));
    }

    public User updatePassword(String username, String password) {

        User user = repository.findUserByUsernameIgnoreCase(username).orElseThrow(() -> new EntityNotFoundException("Người dùng không tồn tại!"));

        user.setPassword(passwordEncoder.encode(password));

        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUsernameIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
