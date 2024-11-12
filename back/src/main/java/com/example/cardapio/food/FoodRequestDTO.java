package com.example.cardapio.food;

public class FoodRequestDTO {

    private String title;
    private String image;
    private Integer price;

    // Getters
    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getPrice() {
        return price;
    }

    // Construtor
    public FoodRequestDTO(String title, String image, Integer price) {
        this.title = title;
        this.image = image;
        this.price = price;
    }
}
