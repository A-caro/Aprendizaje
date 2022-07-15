package com.example.patagoniatest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Integer income;
    private String password;

    public Client(Long id, String fullName, Integer income, String password) {
        this.id = id;
        this.fullName = fullName;
        this.income = income;
        this.password = password;
    }
}
