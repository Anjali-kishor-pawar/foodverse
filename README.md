🍽️ FoodVerse

FoodVerse is a resilient, scalable RESTful service built with Spring Boot 3.4.4 and Java 21.
It manages a wide range of Food Dishes and Order Tracking systems with high availability and fault tolerance.

🚀 Features
🥘 Add single or multiple food items

🗃️ Retrieve all food items

🔍 Search food by Name, Category, or Origin

📦 Track order status by Order ID

🛡️ Fault tolerance using:

  Circuit Breaker

  Retry Mechanism

  Rate Limiter

🌍 Service discovery using Eureka Client

🛢️ Database support: MySQL, PostgreSQL, MongoDB

🔒 JWT-based Authentication (planned)

🧹 Clean error handling and fallback responses


📦 Tech Stack

Layer	              Technology
Backend	            Java 21, Spring Boot 3.4.4
Databases	          MySQL, PostgreSQL, MongoDB
Persistence	        Spring Data JPA, Spring Data MongoDB
Fault Tolerance	    Resilience4j (CircuitBreaker, Retry, RateLimiter)
Service Discovery	  Eureka Client (Spring Cloud Netflix)
Testing	            Postman
Build Tool	        Maven
Others	            Lombok, Actuator, AOP
