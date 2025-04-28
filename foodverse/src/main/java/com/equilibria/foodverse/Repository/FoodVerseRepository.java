package com.equilibria.foodverse.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equilibria.foodverse.Entity.Food;

@Repository
public interface FoodVerseRepository extends JpaRepository<Food,Long>{

    Optional<Food> findByName(String name);

    List<Food> findByCategory(String category);

    List<Food> findByOrigin(String origin);

}
