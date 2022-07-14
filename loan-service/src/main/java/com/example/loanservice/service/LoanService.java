package com.example.loanservice.service;


import com.example.loanservice.entity.Loan;
import com.example.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    public Loan saveLoan(Loan loan){
        Loan newloan = loanRepository.save(loan);
        return newloan;
    }


    public List<Loan> getAll(){
        return loanRepository.findAll();
    }



}
