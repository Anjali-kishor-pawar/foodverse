package com.equilibria.foodverse.Controller;

import java.util.List;
import java.util.Optional;

/* import org.slf4j.Logger;
import org.slf4j.LoggerFactory; */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equilibria.foodverse.Entity.Food;
import com.equilibria.foodverse.Entity.Order;
import com.equilibria.foodverse.Service.FoodVerseService;
/* import com.equilibria.foodverse.Service.FoodVerseServiceImpl; */

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;



@RestController
@RequestMapping("/foodVerse")
public class ControllerFV {

    @Autowired
    private FoodVerseService foodService;


    @GetMapping("/home/")
    public String greetingMessage() {
        return "This is FOOD-VERSE";
    }

    /* @GetMapping("/orderID/{id}")
    public Optional<Order> checkOrderStatus(@PathVariable("id") Long id) {
        return foodService.checkOrderStatus(id);
    } */

   // int retryCount=1;
   int retryCount=1;
    @GetMapping("/orderID/{id}")
    @CircuitBreaker(name="Order_Details_breaker",fallbackMethod = "OrderDetailsFallback")
    @Retry(name="Order_Details_Service",fallbackMethod = "OrderDetailsFallback")
    @RateLimiter(name="Order_Details_Limiter",fallbackMethod = "OrderDetailsFallback")
    public ResponseEntity<Object> checkOrderStatus(@PathVariable("id") Long id) {

        /* logger.info("Retry count : {} ",retryCount);
        retryCount++; */
        retryCount++;
        Optional<Order> order = foodService.checkOrderStatus(id);
       // return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
       if (order.isPresent()) {
        return ResponseEntity.ok(order.get());
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Order not found for ID: " + id);
        }
    }
//Resillience Fall Back

    public ResponseEntity<Object> OrderDetailsFallback(Long id,Exception ex)
    {
       
        Order order = Order.builder()
                    .name("Dummy")
                    .status("Status : Service is down ")
                    .orderid(0L)
                    .build();
        return new ResponseEntity<>(order,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        System.out.println("Controller accept....");
        Food dish1 = foodService.createFood(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(dish1);
    }

    @PostMapping("/bulk-create")
    public List<Food> createMultipleItems(@RequestBody List<Food> foods) {
     
           return foodService.saveAllItems(foods);
    }
    
    @GetMapping("/all")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/Name/{name}")
    public ResponseEntity<Object> getFoodByName(@PathVariable String name) {
        Optional<Food> foodOptional = foodService.getFoodByName(name);
        if (foodOptional.isPresent()) {
            return ResponseEntity.ok(foodOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name +" is available on this platform" );
        }
    }

    @GetMapping("/Category/{category}")
    public ResponseEntity<List<Food>> getFoodByCategory(@PathVariable String category) {
        List<Food> foods = foodService.getFoodByCategory(category);
        if (foods.isEmpty()) {
            return ResponseEntity.noContent().build(); // or notFound()
        }
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/Origin/{origin}")
    public ResponseEntity<List<Food>> getFoodByOrigin(@PathVariable String origin) {
        List<Food> foods = foodService.getFoodByOrigin(origin);
        if (foods.isEmpty()) {
            return ResponseEntity.noContent().build(); // or notFound()
        }
        return ResponseEntity.ok(foods);
    }
    
/* 
    @PutMapping("/{id}")
    public Food updateFood(@PathVariable Long id, @RequestBody Food food) {
        return foodService.updateFood(id, food);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    } */
}


/* import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 @Controller
 public class controllerFV {
 
     //@GetMapping("/foodVerse/home/")
     @RequestMapping("/foodVerse/home/")
     @ResponseBody
     public String greetingMessage() {
         return "This is FOOD-VERSE";
    }
 
 } */