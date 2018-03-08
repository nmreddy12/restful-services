package com.more.rest.webservices.restfulwebservices.customer;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.more.rest.webservices.restfulwebservices.repository.CustomerPageAndSortRepository;
import com.more.rest.webservices.restfulwebservices.repository.CustomerRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerResource {

	Logger logger = LoggerFactory.getLogger(CustomerResource.class);
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerPageAndSortRepository customerPARepository;

	@ApiOperation(value = "Get all Customers details", hidden = true)
	@GetMapping("{siteId}/customers")
	public  List<Customer> retrieveAllCustomers() {
		logger.info("retrieveAllCustomers..");
		return customerRepository.findAll();
		
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
	
	@SuppressWarnings("deprecation")
	@GetMapping("{siteId}/customers/page")
	public Page<Customer> getAllCustomers(){
		return customerPARepository.findAll(new PageRequest(1, 5));
	}
	
	@GetMapping("{siteId}/customers/byemail/{email}")
	public List<Customer> retreiveByEmail(@PathVariable String email){
		
		return customerRepository.findByEmail(email);
		
	}

	@ApiOperation(value = "Get details of a specific customer")
	@GetMapping("{siteId}/customers/{id}")
	public Resource<Customer> retrieveCustomer(@PathVariable Long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent())
			throw new CustomerNotFoundException("id-" + id);

		// "all-users", SERVER_PATH + "/users"
		// retrieveAllUsers
		Resource<Customer> resource = new Resource<Customer>(customer.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllCustomers());

		resource.add(linkTo.withRel("all-users"));

		// HATEOAS

		return resource;
	}

	@ApiOperation(value = "Delete specific customer account")
	@DeleteMapping("{siteId}/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);

	}

	//
	// input - details of user
	// output - CREATED & Return the created URI

	// HATEOAS
	@ApiOperation(value = "Create a new customer account")
	@PostMapping("{siteId}/customers")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
}
