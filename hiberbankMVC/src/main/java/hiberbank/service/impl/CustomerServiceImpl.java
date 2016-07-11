package hiberbank.service.impl;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hiberbank.domain.Customer;
import hiberbank.repository.CustomerRepository;
import hiberbank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private Logger logger;
 
    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        return savedCustomer;
    }
    
    @Override
    @Transactional
	public void deleteCustomer(int id) {
		customerRepository.delete(id);
	}
    
    @Override
    @Transactional(readOnly=true)
	public Customer getByIpn(String ipn) {
		return customerRepository.findByIpn(ipn);
	}
    
	@Override
	@Transactional
	public Customer editCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	
    @Override
    @Transactional(readOnly=true)
    public List<Customer> getAll() {
    	logger.info("Inside " + this.getClass() + " getAll() method");
    	List<Customer> result = customerRepository.findAll();
    	for(Customer customer : result){
    		logger.info("Retrieved customers:" + customer);
    	}
        return result;
    }
}
