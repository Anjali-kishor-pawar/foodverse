package com.equilibria.foodverse.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equilibria.foodverse.ClientCommunication.RestaurantServiceClient;
import com.equilibria.foodverse.Entity.Food;
import com.equilibria.foodverse.Entity.Order;
import com.equilibria.foodverse.Repository.FoodVerseRepository;

@Service
public class FoodVerseServiceImpl implements FoodVerseService{

    @Autowired
    private FoodVerseRepository foodRepository;

    @Autowired
    private RestaurantServiceClient RSClient;

    @Override
    public Food createFood(Food food) {
        /* System.out.println("Serviceimpl accept....");
        if (food.getId() == null) {
        food.setId(UUID.randomUUID().toString());
        } */
        return foodRepository.save(food);
    }

    @Override
    public List<Food> saveAllItems(List<Food> foods) {
        return foodRepository.saveAll(foods);
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Order> checkOrderStatus(Long id) {
        Order order = RSClient.checkOrderStatus(id);
        return Optional.ofNullable(order); // Handles null response safely
    }

    
    @Override
    public Optional<Food> getFoodByName(String name) {
        return foodRepository.findByName(name);
    }

    @Override
    public List<Food> getFoodByCategory(String category) {
        return (List<Food>) foodRepository.findByCategory(category);
    }

   

    @Override
    public List<Food> getFoodByOrigin(String origin) {
        return (List<Food>) foodRepository.findByOrigin(origin);
    }

}


 /*  @Override
    public Food updateFood(Long id, Food food) {
        Food existing = foodRepository.getFoodById(id);
        existing.setName(food.getName());
        existing.setCategory(food.getCategory());
        existing.setPrice(food.getPrice());
        return foodRepository.save(existing);
    } */

    /* @Override
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    } */
