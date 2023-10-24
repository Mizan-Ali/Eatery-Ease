package com.eateryease.diningTable;

import com.eateryease.orders.Orders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dining_table")
public class DiningTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "table_name", nullable = false, length = 256, unique = true)
    private String tableName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "reserved", nullable = false)
    private boolean reserved;

    @Column(name = "reserved_at")
    private LocalDateTime reservedAt;

    @Column(name = "reserve_duration")
    private Integer reserveDuration;

    @OneToMany(mappedBy = "diningTable")
    @JsonIgnore
    private List<Orders> orders;


    // Getters and setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public void setReserveDuration(Integer reserveDuration) {
        this.reserveDuration = reserveDuration;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", price=" + price +
                ", reserved=" + reserved +
                ", reservedAt=" + reservedAt +
                ", reserveDuration=" + reserveDuration +
                '}';
    }
}