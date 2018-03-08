package com.more.rest.webservices.restfulwebservices.customer;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.more.rest.webservices.restfulwebservices.repository.AddressRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class AddressResource {

	@Autowired
	private AddressRepository addressRepository;

	@ApiOperation(value = "Get all Address details")
	@GetMapping("{siteId}/customers/{custId}/addresses")
	public  List<Address> retrieveAllAddresses(@PathVariable Long custId) {
		return addressRepository.findByCustomerId(custId);

//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("email", "firstName");
//
//		FilterProvider filters = new SimpleFilterProvider().addFilter("CustomerFilter", filter);
//
//		MappingJacksonValue mapping = new MappingJacksonValue(customers);
//
//		mapping.setFilters(filters);

		//return customers;

		// return customerRepository2.findAll();
	}
	

	@ApiOperation(value = "Get details of a specific address")
	@GetMapping("{siteId}/customers/{custId}/addresses/{addressId}")
	public Resource<Address> retrieveCustomer(@PathVariable Long addressId) {
		Optional<Address> address = addressRepository.findById(addressId);

		if (!address.isPresent())
			throw new CustomerNotFoundException("id-" + addressId);

		// "all-users", SERVER_PATH + "/users"
		// retrieveAllUsers
		Resource<Address> resource = new Resource<Address>(address.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllAddresses(addressId));

		resource.add(linkTo.withRel("all-users"));

		// HATEOAS

		return resource;
	}

	@ApiOperation(value = "Delete specific customer account")
	@DeleteMapping("{siteId}/customers/{custId}/addresses/{addressId}")
	public void deleteCustomer(@PathVariable Long addressId) {
		addressRepository.deleteById(addressId);

	}

	//
	// input - details of user
	// output - CREATED & Return the created URI

	// HATEOAS
	@ApiOperation(value = "Create a new customer account")
	@PostMapping("{siteId}/customers/{custId}/addresses")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Address address) {
		Address savedCustomer = addressRepository.save(address);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
}
