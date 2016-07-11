package hiberbank.service;

import java.util.List;

import hiberbank.domain.Customer;

public interface CustomerService {
	Customer addCustomer(Customer customer);
	void deleteCustomer(int id);
	Customer getByIpn(String ipn);
	Customer editCustomer(Customer customer);
	List<Customer> getAll();
}
