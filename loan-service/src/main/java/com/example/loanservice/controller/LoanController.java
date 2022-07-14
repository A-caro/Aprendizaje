package com.example.loanservice.controller;

import com.example.loanservice.entity.Loan;
import com.example.loanservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping
    public List<Loan> getAll(){
        return loanService.getAll();
    }

    @PostMapping
    public ResponseEntity<Loan> saveLoan(@RequestBody Loan loan) {
        Loan loanNew = loanService.saveLoan(loan);
        return ResponseEntity.ok(loanNew);
    }




}
