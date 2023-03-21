package com.fu.fcredit.debtor.service;

import com.fu.fcredit.debtor.entity.Debtor;
import com.fu.fcredit.debtor.repository.DebtorRepository;
import com.fu.fcredit.exception.EntityNotFoundException;
import com.fu.fcredit.token.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtorService {
    private final DebtorRepository repository;
    private final JwtService jwtService;

    public Page<Debtor> getDebtors(String token, Pageable pageable) {
        String username = jwtService.extractUsername(token);

        return repository.findAllByUsernameOrderByUpdatedDateDesc(username, pageable);
    }

    public List<Debtor> getTopDebtTotalDesc(String token) {
        String username = jwtService.extractUsername(token);

        return repository.findTop5ByUsernameOrderByDebtTotalDesc(username);
    }

    public List<Debtor> getTopDebtTotalAsc(String token) {
        String username = jwtService.extractUsername(token);

        return repository.findTop5ByUsernameOrderByDebtTotalDesc(username);
    }

    public Debtor addDebtor(Debtor debtor,
                            String username) {

        debtor.setDebtTotal(0L);
        debtor.setCreateDate(new Date());
        debtor.setUpdatedDate(new Date());

        debtor.setUsername(username);

        return repository.save(debtor);
    }

    public Debtor updateDebtor(Long id, Debtor debtor) {
        Debtor oldDebtor = repository.findById(id).get();
        oldDebtor.setAddress(debtor.getAddress());
        oldDebtor.setName(debtor.getName());
        oldDebtor.setPhoneNumber(debtor.getPhoneNumber());
        oldDebtor.setEmail(debtor.getEmail());
        oldDebtor.setUpdatedDate(new Date());
        return repository.save(oldDebtor);
    }

    public Debtor getDebtor(Long id) {
        return repository.findById(id).get();
    }

    public void updateDebtorDebtTotal(Long id, Long money) {
        Debtor debtor = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Người nợ không tồn tại!"));

        debtor.setDebtTotal(debtor.getDebtTotal() + money);
        debtor.setUpdatedDate(new Date());

        repository.save(debtor);
    }
}
