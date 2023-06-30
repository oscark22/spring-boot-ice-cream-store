package com.example.springbooticecreamstore.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Icecream")
public class IceCream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float price; // suppose the price is per 100gr.

    public IceCream() {
    }

    public IceCream(String name, float price) {
        super();
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}