package com.more.rest.webservices.restfulwebservices.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByCustomerId(Long custId);

}
