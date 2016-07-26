package hiberbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import hiberbank.domain.Customer;

public interface CustomerService {
	Customer addCustomer(Customer customer);
	void deleteCustomer(int id);
	Page<Customer> getByIpn(String ipn, Pageable pageRequest);
	Customer editCustomer(Customer customer);
	Page<Customer> findAll(Pageable pageRequest);
	Page<Customer> getFiltered(String name, String ipn, Pageable pageRequest);

}
