package com.ghostack.webtrackerapi.service;

import org.springframework.data.repository.CrudRepository;

import com.ghostack.webtrackerapi.entity.Customer;

public interface RestCustomerService extends CrudRepository<Customer, Integer> {

}
