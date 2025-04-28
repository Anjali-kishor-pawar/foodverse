package com.equilibria.foodverse.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemid;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private double price;

    @Column(name="Category")
    private String category;

    @Column(name="Origin")
    private String origin;


}
