package com.sagar.threadscale.service.impl;

import com.sagar.threadscale.domain.Customer;
import com.sagar.threadscale.domain.FileData;
import com.sagar.threadscale.service.AsyncService;
import com.sagar.threadscale.service.CustomerService;
import com.sagar.threadscale.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {
    @Autowired
    CustomerService customerService;

    @Autowired
    FileService fileService;

    @Async
    public CompletableFuture<List<Customer>> getCustomerByName(String name) {
        log.info("Getting customer {} using Async thread", name);
        List<Customer> customerList = customerService.getCustomerByName(name);
        return CompletableFuture.completedFuture(customerList);
    }

    @Async
    public CompletableFuture<Customer> saveCustomer(Customer customer) {
        log.info("Saving customer {} using Async thread", customer.getName());
        Customer newCustomer = customerService.addCustomer(customer);
        return CompletableFuture.completedFuture(newCustomer);
    }

    @Async
    public CompletableFuture<String> readFile() {
        log.info("Reading the file using Async thread");
        String fileData = fileService.readFile();
        return CompletableFuture.completedFuture(fileData);
    }

    @Async
    public CompletableFuture<Boolean> writeFile(FileData fileData) {
        log.info("Writing to file using Async thread");
        boolean result = fileService.writeFile(fileData);
        return CompletableFuture.completedFuture(result);
    }
}
