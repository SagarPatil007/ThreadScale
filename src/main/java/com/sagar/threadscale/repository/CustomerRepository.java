package com.sagar.threadscale.repository;

import com.sagar.threadscale.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByName(String name);
    List<Customer> findByRole(String role);
}