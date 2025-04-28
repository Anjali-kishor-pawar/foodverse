package com.equilibria.restaurantserviceapplication.Service;

import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import com.equilibria.restaurantserviceapplication.Entity.Order;
//import com.equilibria.restaurantserviceapplication.RestaurantRepository.RestaurantRepository;


public interface RestaurantService {

    Optional<Order> getOrderById(Long orderId);

    Order createOrder(Order order);

}
