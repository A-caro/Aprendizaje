package com.example.patagoniatest.feignclients;

import com.example.patagoniatest.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name ="loanservice")
@RequestMapping("/loan")

public interface LoanFeignClient {

    @PostMapping()
    Loan saveLoan(@RequestBody Loan loan);
}
