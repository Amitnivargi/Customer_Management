package com.AmitNivargi.Albanero.service;

import com.AmitNivargi.Albanero.Entity.Customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
    Map<String, List<Customer>> groupBy(String inputColumn);
    Map<String, Customer> removeDuplicates(String inputColumn);


}
