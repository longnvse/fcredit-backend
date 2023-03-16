package com.fu.fcredit.debtor.controller;

import com.fu.fcredit.debtor.entity.DebtorEntity;
import com.fu.fcredit.debtor.service.DebtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/debtor")
@RequiredArgsConstructor
public class DebtorController {

    @Autowired
    public final DebtorService debtorService;

    @PostMapping("/add")
    public ResponseEntity<DebtorEntity> createNewCategory(@RequestBody DebtorEntity deptor) {
        return new ResponseEntity<>(debtorService.save(deptor), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<DebtorEntity>> getAllDeptor() {
        return new ResponseEntity<>(debtorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DebtorEntity> getDeptorById(@PathVariable Long id) {
        Optional<DebtorEntity> deptorOptional = debtorService.findById(id);
        return deptorOptional.map(deptor -> new ResponseEntity<>(deptor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/borrow/{id}")
    public ResponseEntity<DebtorEntity> borowDeptor(@PathVariable Long id, @RequestBody DebtorEntity deptor, @RequestBody int moneyBorrow) {
        Optional<DebtorEntity> deptorOptional = debtorService.findById(id);
        return deptorOptional.map(_deptor -> {
            deptor.setTotalDebt(_deptor.getTotalDebt()-moneyBorrow);

            //chưa làm
//            deptor.setDateUpdate();
            return new ResponseEntity<>(debtorService.save(deptor), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/loan/{id}")
    public ResponseEntity<DebtorEntity> loanDeptor(@PathVariable Long id, @RequestBody DebtorEntity deptor, @RequestBody int moneyLoan) {
        Optional<DebtorEntity> deptorOptional = debtorService.findById(id);
        return deptorOptional.map(_deptor -> {
            deptor.setTotalDebt(_deptor.getTotalDebt()+moneyLoan);

            //chưa làm
//            deptor.setDateUpdate();
            return new ResponseEntity<>(debtorService.save(deptor), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DebtorEntity> deleteDeptor(@PathVariable Long id) {
        Optional<DebtorEntity> deptorOptional = debtorService.findById(id);
        return deptorOptional.map(deptor -> {
            debtorService.remove(id);
            return new ResponseEntity<>(deptor, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
