package com.AmitNivargi.Albanero.service;

import com.AmitNivargi.Albanero.Entity.Customer;
import com.AmitNivargi.Albanero.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customer.setId(id);
            return customerRepository.save(customer);
        } else {
            throw new NoSuchElementException("Customer not found with id: " + id);
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Customer not found with id: " + id);
        }
    }

    @Override
    public Map<String, List<Customer>> groupBy(String inputColumn) {
        List<Customer> customers = customerRepository.findAll();
        Map<String, List<Customer>> result = new HashMap<>();
        for (Customer customer : customers) {
            String key = "";
            switch (inputColumn) {
                case "firstName":
                    key = customer.getFirstName();
                    break;
                case "lastName":
                    key = customer.getLastName();
                    break;
                case "address":
                    key = customer.getAddress();
                    break;
                case "pincode":
                    key = customer.getPincode();
                    break;
                case "phoneNumber":
                    key = customer.getPhoneNumber();
                    break;
                case "city":
                    key = customer.getCity();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input column: " + inputColumn);
            }
            List<Customer> list = result.getOrDefault(key, new ArrayList<>());
            list.add(customer);
            result.put(key, list);
        }
        return result;
    }

    public Map<String, Customer> removeDuplicates(String inputColumn) {
        List<Customer> customers = customerRepository.findAll();
        Map<String, Customer> uniqueCustomers = new HashMap<>();

        for (Customer customer : customers) {
            String key = customer.getPropertyValue(inputColumn).toString();
            if (!uniqueCustomers.containsKey(key)) {
                uniqueCustomers.put(key, customer);
            }
        }

        return uniqueCustomers;
    }




}