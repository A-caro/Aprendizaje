package com.example.patagoniatest.controller;

import com.example.patagoniatest.entity.Client;
import com.example.patagoniatest.model.Loan;
import com.example.patagoniatest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/addClient")
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

    @PostMapping("/saveloan/{clientId}")
    public ResponseEntity<Loan> saveLoan(@PathVariable("clientId") Long clientId, @RequestBody Loan loan) {
        Loan loanNew = clientService.saveLoan(clientId, loan);
        return ResponseEntity.ok(loan);
    }




}
