package com.example.EcomarketSPAweb.Model;


import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GetMapping(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String description;
    private int stock;
}
