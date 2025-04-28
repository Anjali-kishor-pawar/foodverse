package com.equilibria.identity_service.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equilibria.identity_service.Entity.UserCredential;

public interface UserCredentialRepository extends MongoRepository<UserCredential,String> {

    Optional<UserCredential> findByName(String username);

    boolean existsByName(String name);

}

