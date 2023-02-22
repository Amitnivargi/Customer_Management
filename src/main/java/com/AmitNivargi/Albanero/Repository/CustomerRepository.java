package com.AmitNivargi.Albanero.Repository;

import java.util.List;

import com.AmitNivargi.Albanero.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
