package com.example.cardapio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    // Endpoint simples de teste
    @GetMapping("/")
    public String home() {
        return "Servidor funcionando!";
    }

    // Endpoint para salvar um novo prato
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Define o status 201 Created
    public void saveFood(@RequestBody FoodRequestDTO data) {
        // Criação do objeto Food a partir do DTO recebido
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    // Endpoint para obter todos os pratos
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        // Converte a lista de Food para uma lista de FoodResponseDTO
        return repository.findAll().stream()
                .map(food -> new FoodResponseDTO(food))
                .collect(Collectors.toList());
    }
}
