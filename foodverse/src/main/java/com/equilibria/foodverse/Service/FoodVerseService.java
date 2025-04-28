package com.equilibria.foodverse.Service;

import java.util.List;
import java.util.Optional;

import com.equilibria.foodverse.Entity.Food;
import com.equilibria.foodverse.Entity.Order;

public interface FoodVerseService {

    public Food createFood(Food food);
    public List<Food> saveAllItems(List<Food> foods);
    public List<Food> getAllFoods();
    Optional<Order> checkOrderStatus(Long id);
    Optional<Food> getFoodByName(String name);
    List<Food> getFoodByCategory(String category);
    List<Food> getFoodByOrigin(String origin);
    //Food updateFood(Long id, Food food);
    //void deleteFood(Long id);

}
