package com.example.patagoniatest.service;

import com.example.patagoniatest.entity.Client;
import com.example.patagoniatest.feignclients.LoanFeignClient;
import com.example.patagoniatest.model.Loan;
import com.example.patagoniatest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ClientService {

    @Autowired
    LoanFeignClient loanFeignClient;

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public void updateCliente(Long id, Client cliente){
        Optional<Client> client = clientRepository.findById(id);
        try{
            client.isPresent();
            if (!client.get().equals(cliente.getFullName())){
                client.get().setFullName(cliente.getFullName());
            } if(client.get().equals(cliente.getIncome())){
                client.get().setIncome(cliente.getIncome());
            }
    }catch (IllegalStateException e){
            System.out.println("El id solicitado no existe" + e.getMessage());
        }
        clientRepository.save(client.get());
    }

    public Loan saveLoan(Long clientId, Loan loan){
        loan.setClientId(clientId);
        Loan loanNew = loanFeignClient.saveLoan(loan);
        return loanNew;
    }

}

