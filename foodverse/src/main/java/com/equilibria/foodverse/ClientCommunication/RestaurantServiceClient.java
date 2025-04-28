package com.equilibria.foodverse.ClientCommunication;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.equilibria.foodverse.Entity.Order;

@Component
public class RestaurantServiceClient {

    @Autowired
    private RestTemplate temp;

    public Order checkOrderStatus(Long orderId)
    {
        //return temp.getForObject("http://localhost:9091/restaurant/status/" + orderId, Order.class);
       return temp.getForObject("http://Restaurant-Service/restaurant/status/" + orderId, Order.class);
    }

}
