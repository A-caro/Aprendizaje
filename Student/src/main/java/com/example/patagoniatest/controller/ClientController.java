package com.example.patagoniatest.controller;

import com.example.patagoniatest.entity.Client;
import com.example.patagoniatest.model.Loan;
import com.example.patagoniatest.service.ClientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id){
        return clientService.findById(id);
    }


    @PutMapping("/update/{id}")
    public void updateCliente(@PathVariable Long id, @RequestBody Client client){
        clientService.updateCliente(id, client);
    }

    @GetMapping("/datos")
    public String getDatos(){
        return clientService.getDatos();
    }

    @CircuitBreaker(name = "clientCB", fallbackMethod = "fallBackSaveLoan")
    @PostMapping("/saveloan/{clientId}")
    public ResponseEntity<Loan> saveLoan(@PathVariable("clientId") Long clientId, @RequestBody Loan loan) {
        Loan loanNew = clientService.saveLoan(clientId, loan);
        return ResponseEntity.ok(loan);
    }

    private ResponseEntity<Loan> fallBackSaveLoan(@PathVariable("clientId") Long clientId, @RequestBody Loan loan, RuntimeException exception){
        return new ResponseEntity("El cliente " + clientId + "  no puede recibir un prestamo()CB",  HttpStatus.OK);
    }

}
