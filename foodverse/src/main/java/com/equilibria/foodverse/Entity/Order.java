package com.equilibria.foodverse.Entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Order {
    
    private Long orderid;

    private String name;

    private int qty;

    private double price;

  
    private String category;

    
    private Date orderDate;

    
    private String status;

    private int estimateDeliveryWindow;

}
 