package com.sagar.threadscale.service;

import com.sagar.threadscale.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomerByName(String name);

    Customer addCustomer(Customer customer);
}
