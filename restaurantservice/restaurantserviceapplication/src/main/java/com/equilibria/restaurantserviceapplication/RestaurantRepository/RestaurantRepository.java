package com.equilibria.restaurantserviceapplication.RestaurantRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equilibria.restaurantserviceapplication.Entity.Order;

@Repository
public interface RestaurantRepository extends JpaRepository<Order,Long>{

    /* @Override
    Optional<Order> findById(Long id);
     */
}
