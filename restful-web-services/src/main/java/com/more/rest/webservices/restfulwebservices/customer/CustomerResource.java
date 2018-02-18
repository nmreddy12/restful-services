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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerResource {
	
		@Autowired
		private CustomerRepository customerRepository;

		@ApiOperation(value="Get all Customers details", hidden=true)
		@GetMapping("{siteId}/customers")
		public List<Customer> retrieveAllCustomers() {
			return customerRepository.findAll();
		}

		@ApiOperation(value="Get details of a specific customer")
		@GetMapping("{siteId}/customers/{id}")
		public Resource<Customer> retrieveCustomer(@PathVariable int id) {
			Optional<Customer> customer = customerRepository.findById(id);
			
			if(!customer.isPresent())
				throw new CustomerNotFoundException("id-"+ id);
			
			//"all-users", SERVER_PATH + "/users"
			//retrieveAllUsers
			Resource<Customer> resource = new Resource<Customer>(customer.get());
			
			ControllerLinkBuilder linkTo = 
					linkTo(methodOn(this.getClass()).retrieveAllCustomers());
			
			resource.add(linkTo.withRel("all-users"));
			
			//HATEOAS
			
			return resource;
		}

		@ApiOperation(value="Delete specific customer account")
		@DeleteMapping("{siteId}/customers/{id}")
		public void deleteCustomer(@PathVariable int id) {
			customerRepository.deleteById(id);
			
		}

		//
		// input - details of user
		// output - CREATED & Return the created URI
		
		//HATEOAS
		@ApiOperation(value="Create a new customer account")
		@PostMapping("{siteId}/customers")
		public ResponseEntity<Object> createUser(@Valid @RequestBody Customer customer) {
			Customer savedCustomer = customerRepository.save(customer);
			
			URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();
			
			return ResponseEntity.created(location).build();
			
		}
	}

