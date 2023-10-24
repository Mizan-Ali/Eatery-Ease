package com.eateryease.menu;
import com.eateryease.diningTable.DiningTable;
import com.eateryease.orders.Orders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dish_name", nullable = false, length = 256)
    private String dishName;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "available", nullable = false)
    private boolean available;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    private List<Orders> orders;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
