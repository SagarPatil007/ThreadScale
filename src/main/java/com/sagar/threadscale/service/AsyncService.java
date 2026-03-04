package com.sagar.threadscale.service;

import com.sagar.threadscale.domain.Customer;
import com.sagar.threadscale.domain.FileData;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncService {

    CompletableFuture<List<Customer>> getCustomerByName(String name);

    CompletableFuture<Customer> saveCustomer(Customer customer);

    CompletableFuture<String> readFile();

    CompletableFuture<Boolean> writeFile(FileData fileData);
}
