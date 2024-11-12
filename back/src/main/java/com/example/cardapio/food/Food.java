package com.example.cardapio.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foods")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String image;
    private Integer price;

    // Construtor que converte o DTO em entidade
    public Food(FoodRequestDTO data) {
        if (data != null) {  // Verifica se o DTO não é nulo
            this.title = data.getTitle();  
            this.image = data.getImage();  
            this.price = data.getPrice();  
        }
    }
}
