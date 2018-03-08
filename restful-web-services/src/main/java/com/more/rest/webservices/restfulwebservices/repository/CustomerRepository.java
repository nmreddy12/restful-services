package com.more.rest.webservices.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.more.rest.webservices.restfulwebservices.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByEmail(String email);

}
