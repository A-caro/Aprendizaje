package com.example.patagoniatest.feignclients;

import com.example.patagoniatest.model.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="subjectservice")
@RequestMapping("/subject")

public interface SubjectFeignClient {

    @PostMapping()
    Subject saveSubject(@RequestBody Subject Subject);



}
