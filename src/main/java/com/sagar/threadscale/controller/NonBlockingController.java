package com.sagar.threadscale.controller;

import com.sagar.threadscale.domain.Customer;
import com.sagar.threadscale.domain.FileData;
import com.sagar.threadscale.service.AsyncService;
import com.sagar.threadscale.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/nonblocking")
public class NonBlockingController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/customers/{name}")
    public CompletableFuture<List<Customer>> getCustomerByName(@PathVariable String name) {
        log.info("Getting customer by name {} ", name);
        return asyncService.getCustomerByName(name);
    }

    @PostMapping("/customers/save")
    public CompletableFuture<Customer> addCustomer(@RequestBody Customer customer) {
        log.info("Adding user {} to the Database", customer.getName());
        return asyncService.saveCustomer(customer);
    }

    @GetMapping("/fileread")
    public CompletableFuture<String> readFile() {
        log.info("reading file request");
        return asyncService.readFile();
    }

    @PostMapping("/filewrite")
    public CompletableFuture<Boolean> writeFile(@RequestBody FileData fileData) {
        log.info("Write data {} to File", fileData);
        return asyncService.writeFile(fileData);
    }
}
