package com.fu.fcredit.service.Implement;

import com.fu.fcredit.entity.DeptorEntity;
import com.fu.fcredit.service.DeptorService;
import com.fu.fcredit.repository.DeptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class DeptorServiceImp implements DeptorService {

    @Autowired
    private DeptorRepository deptorRepository;

    @Override
    public Iterable<DeptorEntity> findAll() {
        return deptorRepository.findAll();
    }

    @Override
    public Optional<DeptorEntity> findById(Long id) {
        return deptorRepository.findById(id);
    }

    @Override
    public DeptorEntity save(DeptorEntity deptor) {
        return deptorRepository.save(deptor);
    }

    @Override
    public void remove(Long id) {
        deptorRepository.deleteById(id);
    }

}
