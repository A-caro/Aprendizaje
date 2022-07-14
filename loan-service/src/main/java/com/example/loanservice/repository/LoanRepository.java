package com.example.loanservice.repository;

import com.example.loanservice.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanRepository extends JpaRepository<Loan, Long> {

}
