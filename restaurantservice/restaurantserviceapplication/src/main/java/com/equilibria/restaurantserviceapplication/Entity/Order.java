package com.equilibria.restaurantserviceapplication.Entity;

import java.util.Date;
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
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Order {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;

    @Column(name="Name")
    private String name;

    @Column(name="Quantity")
    private int qty;

    @Column(name="Price")
    private double price;

    @Column(name="Category")
    private String category;

    @Column(name="OrderDate")
    private Date orderDate;

    @Column(name="status")
    private String status;

    @Column(name="DeliveryWindow")
    private int estimateDeliveryWindow;

}
 