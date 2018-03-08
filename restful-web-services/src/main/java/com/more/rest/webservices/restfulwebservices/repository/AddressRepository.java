package com.more.rest.webservices.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.more.rest.webservices.restfulwebservices.customer.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByCustomerId(Long custId);

}
