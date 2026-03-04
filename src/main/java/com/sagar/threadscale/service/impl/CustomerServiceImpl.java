package com.sagar.threadscale.service.impl;

import com.sagar.threadscale.domain.Customer;
import com.sagar.threadscale.repository.CustomerRepository;
import com.sagar.threadscale.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomerByName(String name) {
        log.info("Getting customer {} from the repository.", name);
        List<Customer> customerList = customerRepository.findByName(name);
        if (CollectionUtils.isEmpty(customerList)) {
            log.info("No customer found by name {}", name);
            return new ArrayList<>();
        }
        log.info("found {} customers by name {}", customerList.size(), name);
        return customerList;
    }

    @Override
    public Customer addCustomer(Customer cstm) {
        log.info("Adding customer {} to database", cstm.getName());
        Customer customer = customerRepository.insert(cstm);
        log.info("Added customer {} successfully", customer.getName());
        return customer;
    }
}
