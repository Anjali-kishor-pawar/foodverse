package com.equilibria.restaurantserviceapplication.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equilibria.restaurantserviceapplication.Entity.Order;
//import com.equilibria.restaurantserviceapplication.Service.RSImpl;
//import com.equilibria.restaurantserviceapplication.Service.RestaurantService;
import com.equilibria.restaurantserviceapplication.Service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService Rservice;

    @GetMapping
    public String greetingMessage() {
        return "This is restaurant - service";
    }

    @GetMapping("/status/{orderId}")
    public Optional<Order> getOrder(@PathVariable Long orderId) {
        return Rservice.getOrderById(orderId);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        System.out.println("Controller order accept....");
        Order dish1 = Rservice.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(dish1);
    }

}
