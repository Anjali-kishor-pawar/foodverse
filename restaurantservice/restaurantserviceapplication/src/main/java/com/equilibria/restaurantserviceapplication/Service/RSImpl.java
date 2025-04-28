package com.equilibria.restaurantserviceapplication.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equilibria.restaurantserviceapplication.Entity.Order;
import com.equilibria.restaurantserviceapplication.RestaurantRepository.RestaurantRepository;

@Service
public class RSImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository repo;

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return repo.findById(orderId);

    }

    @Override
    public Order createOrder(Order order) {
        /* System.out.println("Serviceimpl accept....");
        if (food.getId() == null) {
        food.setId(UUID.randomUUID().toString());
        } */
        return repo.save(order);
    }

}
