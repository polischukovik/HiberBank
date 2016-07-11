package hiberbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiberbank.domain.Customer;
import hiberbank.repository.CustomerRepository;
import hiberbank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
 
    @Override
    public Customer addCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        return savedCustomer;
    }
    
    @Override
	public void deleteCustomer(int id) {
		customerRepository.delete(id);
	}
    
    @Override
	public Customer getByIpn(String ipn) {
		return customerRepository.findByIpn(ipn);
	}
    
	@Override
	public Customer editCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
