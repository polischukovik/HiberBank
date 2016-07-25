package hiberbank.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import hiberbank.domain.Customer;

public interface CustomerService {
	Customer addCustomer(Customer customer);
	void deleteCustomer(int id);
	Page<Customer> getByIpn(String ipn, PageRequest pageRequest);
	Customer editCustomer(Customer customer);
	Page<Customer> getAll(PageRequest pageRequest);
	Page<Customer> getFiltered(String name, String ipn, PageRequest pageRequest);
}
