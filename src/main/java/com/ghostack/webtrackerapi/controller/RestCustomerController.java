package com.ghostack.webtrackerapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghostack.webtrackerapi.entity.Customer;
import com.ghostack.webtrackerapi.service.RestCustomerService;

@RestController
@RequestMapping("/api")
public class RestCustomerController {

	@Autowired
	RestCustomerService service;
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Optional<Customer> optional = service.findById(id);
		Customer customer = null;
		if(optional.isPresent())
			customer = optional.get();
		return customer;
	}
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		 return (List<Customer>) service.findAll();
		 
	}
	@PostMapping("/customers")
	public void saveCustomer(@RequestBody Customer customer) {
		service.save(customer);
	}
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		service.save(customer);
	}
	@DeleteMapping("/customers/{custId}")
	public void deleteCustomer(@PathVariable int custId) {
		service.deleteById(custId);
	}
}
