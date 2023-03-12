package com.fu.fcredit.controller;

import com.fu.fcredit.entity.DeptorEntity;
import com.fu.fcredit.service.DeptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/deptor")
public class DeptorController {

    @Autowired
    public DeptorService deptorService;

    @PostMapping("/add")
    public ResponseEntity<DeptorEntity> createNewCategory(@RequestBody DeptorEntity deptor) {
        return new ResponseEntity<>(deptorService.save(deptor), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<DeptorEntity>> getAllDeptor() {
        return new ResponseEntity<>(deptorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeptorEntity> getDeptorById(@PathVariable Long id) {
        Optional<DeptorEntity> deptorOptional = deptorService.findById(id);
        return deptorOptional.map(deptor -> new ResponseEntity<>(deptor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/borrow/{id}")
    public ResponseEntity<DeptorEntity> borowDeptor(@PathVariable Long id, @RequestBody DeptorEntity deptor, @RequestBody int moneyBorrow) {
        Optional<DeptorEntity> deptorOptional = deptorService.findById(id);
        return deptorOptional.map(_deptor -> {
            deptor.setTotalDept(_deptor.getTotalDept()-moneyBorrow);

            //chưa làm
//            deptor.setDateUpdate();
            return new ResponseEntity<>(deptorService.save(deptor), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/loan/{id}")
    public ResponseEntity<DeptorEntity> loanDeptor(@PathVariable Long id, @RequestBody DeptorEntity deptor, @RequestBody int moneyLoan) {
        Optional<DeptorEntity> deptorOptional = deptorService.findById(id);
        return deptorOptional.map(_deptor -> {
            deptor.setTotalDept(_deptor.getTotalDept()+moneyLoan);

            //chưa làm
//            deptor.setDateUpdate();
            return new ResponseEntity<>(deptorService.save(deptor), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeptorEntity> deleteDeptor(@PathVariable Long id) {
        Optional<DeptorEntity> deptorOptional = deptorService.findById(id);
        return deptorOptional.map(deptor -> {
            deptorService.remove(id);
            return new ResponseEntity<>(deptor, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
